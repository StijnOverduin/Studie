package ss.week1;

public class Student {
	private int score;
	
	public Student (int score){
		this.score = score;
	}
	public static void main(String[] args){
		Student Stijn = new Student(69);
		System.out.println(Stijn.pass());
		
	}
	public int getScore(){
		return score;
	}
	public boolean pass(){
		if (score >= 70) 
				return true;
		else
			return false;
	}
}
