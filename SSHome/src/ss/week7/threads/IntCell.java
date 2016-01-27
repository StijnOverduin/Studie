package ss.week7.threads;

/**
 * Interface used in Producer/Consumer program.
 */
public interface IntCell {
	public void setValue(int val);
	public int getValue();
}
/*1.  1, 2 of 3
 *2. 3 omdat ze dan niet parallel gaan lopen en dus beide dezelfde thread gebruiken.
 *3. Hij kan een InterruptedException gooien
 *4. 3 omdat hij dan synchronized loopt.
 *5. 
 */
