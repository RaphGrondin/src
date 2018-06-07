package Model;

public class Drone extends Element {
	private float fuel;
	private int score;
	
	public Drone(float x, float y, String name, int size, float fuel, int score) {
		super(x,y,name,size);
		this.fuel = fuel;
		this.score = score;
		System.out.println("Test");
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public float getFuel() {
		return this.fuel;
	}
	
	public void setFuel(float fuel) {
		this.fuel = fuel;
	}
}
