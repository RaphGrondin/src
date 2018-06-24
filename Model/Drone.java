package Model;

public class Drone extends Element {
	private float fuel;
	private int score;

	public Drone(String name, int size) {
		super(name);
		this.setSize(size);
		this.setImage("src/Model/_img/drone/drone.png");
		this.fuel = 100;
		this.score = 0;
	}

	public Drone(float x, float y, String name, int size, float fuel, int score) {
		super(x,y,name,size);
		this.setImage("src/Model/_img/drone/drone.png");
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
