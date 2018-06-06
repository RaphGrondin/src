package Model;

public class Drone extends Element {
	private float fuel;
	private int score;
	
	public Drone(float fuel, int score) {
		super();
		this.fuel = fuel;
		this.score = score;
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
