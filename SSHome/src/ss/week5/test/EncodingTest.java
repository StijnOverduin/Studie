package ss.week5.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding of the Apache Commons
 * Codec library.
 *
 */
public class EncodingTest {
	public static void main(String[] args) throws DecoderException {
		String input = "Hello World";
		System.out.println("1" + Hex.encodeHexString(input.getBytes()));
		System.out.println("2" + new String(Hex.decodeHex("48656c6c6f20576f726c64".toCharArray())));
		System.out.println("3" + Base64.encodeBase64String(input.getBytes()));
		System.out.println("4" + new String(Base64.encodeBase64(Hex.decodeHex("010203040506".toCharArray()))));
		System.out.println("5" + new String(Base64.decodeBase64("U29mdHdhcmUgU3lzdGVtcw==".getBytes())));
		System.out.println(Base64.encodeBase64String("a".getBytes()));
		System.out.println(Base64.encodeBase64String("aa".getBytes()));
		System.out.println(Base64.encodeBase64String("aaa".getBytes()));
		System.out.println(Base64.encodeBase64String("aaaa".getBytes()));
		System.out.println(Base64.encodeBase64String("aaaaa".getBytes()));
		System.out.println(Base64.encodeBase64String("aaaaaaaaaaaaa".getBytes()));
	}
}
