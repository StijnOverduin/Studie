package ss.week2;

public class Rectangle {
	private int length;
	private int width;

	/*
	 *@ requires l>=0 && w>=0;
	 */
	public Rectangle(int l, int w) {
		length = l;
		width = w;
		assert l >= 0 && w >= 0;
	}

	/*
	 *@ ensures \result>=0;
	 *@ require length >=0;
	 */
	/*@pure*/ public int length() {
		assert length >= 0;
		return length;
	}

	/*
	 *@ ensures \result>=0;
	 */
	/*@pure*/ public int width() {
		assert width >= 0;
		return width;
	}

	/*
	 *@ ensures length * width >=\result;
	 */
	/*@pure*/ public int area() {
		assert length * width >= 0;
		return length * width;
	}

	/*
	 *@ ensures \result>=0;
	 */
	/*@pure*/ public int perimeter() {
		assert (length * 2) + (width * 2) >= 0;
		return (length * 2) + (width * 2);
	}
}
