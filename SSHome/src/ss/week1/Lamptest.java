package ss.week1;

public class Lamptest {
	
	public static void main(String[] args) {
		Lamp testlamp = new Lamp(0);
		
		System.out.println("Verwacht 0, het is " + testlamp.getState() + "");
		testlamp.switchState();
		System.out.println("Verwacht 1, het is " + testlamp.getState() + "");
		testlamp.switchState();
		System.out.println("Verwacht 2, het is " + testlamp.getState() + "");
		testlamp.switchState();
		System.out.println("Verwacht 3, het is " + testlamp.getState() + "");
		testlamp.switchState();
		System.out.println("Verwacht 0, het is " + testlamp.getState() + "");
	}
		
	
}
