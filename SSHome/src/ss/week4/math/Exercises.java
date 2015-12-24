package ss.week4.math;

public class Exercises {

	public static int countNegativeNumbers(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				sum += 1;
			}
		}
		return sum;
	}

	public static void reverseArray(int[] values) {
		int i = 0;
		while (i < (values.length - 1) / 2) {
			int low = values[i];
			values[i] = values[values.length - i - 1];
			values[values.length - i - 1] = low;
			i++;
		}
		
	}

	class SimpleList {
		public class Element {
		}

		public class Node {
			public Node next;
			public Element element;
		}

		private Node first;

		private Node find(Element element) {
			Node p = first;
			if (p == null) {
				return null;
			}
			while (p.next != null && !p.next.element.equals(element)) {
				p = p.next;
			}
			if (p.next == null) {
				return null;
			} else {
				return p;
			}
		}

		public void remove(Element element) {
			Node p = find(element);
			if (p != null) {
				p.next = p.next.next;
			}
		}
	}
}
