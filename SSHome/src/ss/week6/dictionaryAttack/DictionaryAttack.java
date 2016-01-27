package ss.week6.dictionaryAttack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.Hex;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;
	
	public DictionaryAttack() {
		this.passwordMap = new HashMap<String, String>();
		this.hashDictionary = new HashMap<String, String>();
	}

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) throws IOException {
		try (Scanner in = new Scanner(new FileInputStream(filename))) {
			while (in.hasNextLine()) {
				String nl = in.nextLine();
				String[] userPass = nl.split(": ");
				passwordMap.put(userPass[0], userPass[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		String result = null;
		try {
			MessageDigest MD5 = MessageDigest.getInstance("MD5");
			byte[] hash = MD5.digest(password.getBytes());
			result = new String(Hex.encodeHex(hash));	
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		if (passwordMap.containsKey(user)) {
			return passwordMap.get(user).equals(getPasswordHash(password));
		} else {
			return false;
		}
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
	public void addToHashDictionary(String filename) {
		try (Scanner in = new Scanner(new FileInputStream(filename))) {
			while (in.hasNextLine()) {
				String line = in.nextLine();
				hashDictionary.put(line, getPasswordHash(line));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		for (Map.Entry<String, String> e: passwordMap.entrySet()) {
			String value = e.getValue();
			for (Map.Entry<String, String> f: hashDictionary.entrySet()) {
				if (f.getValue().equals(value)) {
					System.out.println("Username: " + e.getKey() + " Password: " + f.getKey());
				}
			}
		}
	}
	public void bruteFore() {
		char pos1 = 'a';
		while (pos1 <= 'z') {
			char pos2 = 'a';
			while (pos2 <= 'z') {
				char pos3 = 'a';
				while (pos3 <= 'z') {
					char pos4 = 'a';
					while (pos4 <= 'z') {
						String pass = "" + pos1 + pos2 + pos3 + pos4;
						if (checkPassword("alice", pass)) {
							System.out.println("Alices pass is " + pass); 
							pos1 = 'z' + 1;
							pos2 = 'z' + 1;
							pos3 = 'z' + 1;
							pos4 = 'z' + 1;
						}
						pos4++;
					}
					pos3++;
				}
				pos2++;
			}
			pos1++;
		}
				
	}
	public static void main(String[] args) throws IOException {
		String path = "C:/SSHome/workspace/week6/src/dictionaryattack/";
		DictionaryAttack da = new DictionaryAttack();
		da.readPasswords(path + "LeakedPasswords.txt");
		da.addToHashDictionary(path + "linux_words.txt");
		da.doDictionaryAttack();
		da.bruteFore();
	}

}
