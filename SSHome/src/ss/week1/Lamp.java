package ss.week1;

public class Lamp {
	private int state;
	
	public Lamp(int state){
		this.state = state;
	}
	public static void main(String[] args){
		Lamp kamerlamp = new Lamp(0);
		
		kamerlamp.switchState();
		System.out.println(kamerlamp.getState());
		kamerlamp.switchState();
		System.out.println(kamerlamp.getState());
		kamerlamp.switchState();
		System.out.println(kamerlamp.getState());
		kamerlamp.switchState();
		System.out.println(kamerlamp.getState());
		
		}
	public void switchState(){
		state = (state + 1) % 4;
	}
	
	public int getState(){
		return state;
	}

}

