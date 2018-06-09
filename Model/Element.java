package Model;

import java.util.Random;

public abstract class Element {
	protected Vec position;
	protected String name;
	protected int size;
	
	public Element() {
		Random rnd = new Random();

		int x = rnd.nextInt(GameManager.getLargeur());
		int y = rnd.nextInt(GameManager.getHauteur());

		this.name = "NULL";
		this.size = 0;
		this.position = new Vec(x,y);
	}

	public Element(String name) {
		this();
		this.name = name;
	}

	public Element(double x, double y, String name, int size) {
		this.position = new Vec(x,y);
		this.name = name;
		this.size = size;
	}

	public Element (double x, double y) {
		this.position = new Vec(x,y);
		this.name = "Null";
		this.size = 0;
	}
	
	public double getX() {
		return this.position.getX();
	}
	
	public void setX(double x) {
		this.position.setX(x);
	}
	
	public double getY() {
		return this.position.getY();
	}
	
	public void setY(double y) {
		this.position.setY(y);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
}
