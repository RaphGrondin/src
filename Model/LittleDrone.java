package Model;

public class LittleDrone extends Drone {

	public LittleDrone(String name) {
		super(name,10);
	}

	public LittleDrone(float x, float y, String name, float fuel, int score) {
		super(x, y, name, 20, fuel, score);
		// TODO Auto-generated constructor stub
	}

}
