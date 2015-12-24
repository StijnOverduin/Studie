package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//"error: length of command line arguments "
//+ "differs (" + length1 + ", " + length2 + ")"
	public ArgumentLengthsDifferException(int length1, int length2) { 
		super("error: length of command line arguments "
				+ "differs (" + length1 + ", " + length2 + ")");
	}

}
