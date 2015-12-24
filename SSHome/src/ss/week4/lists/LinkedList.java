package ss.week4.lists;

public class LinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node first;

    //@ ensures this.size == 0;
    public LinkedList() {
        size = 0;
        first = null;
    }

    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index - 1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }

    //@ ensures this.size == \old(size) - 1;
    public void remove(Element element) {
        Node previous = findBefore(element);
        Node h = find(element);
        if (previous == null && h == null) {
        	
        } else if (previous == null && h != null) {
        	Node next = find(element).next;
        	first = next;
        } else {
        	Node next = find(element).next;
        	previous.next = next;
     	   
        }
        size = size - 1;
    }

    public Node findBefore(Element element) {
    	Node node = first;
    	if (element == first.getElement()) {
			return null;
		} 
    	for (int i = 0; i < size; i++) {
    		if (element == node.next.getElement()) {
            	return node;
            } else {
            	node = node.next;
            }
    	}
        return null;
    }
    
    public Node find(Element element) {
    	Node node = first;
    	for (int i = 0; i < size; i++) {
    		if (element == node.getElement()) {
            	return node;
            } else {
            	node = node.next;
            }
    	}
        
        
        return null;
    }

    //@ requires 0 <= index && index < this.size();
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    //@ requires 0 <= i && i < this.size();
    private /*@ pure @*/ Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    //@ ensures \result >= 0;
    public /*@ pure @*/ int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
