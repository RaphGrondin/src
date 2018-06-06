package Model;

public class Element {
	private float x;
	private float y;
	private String name;
	
	public Element() {
		this.x = 0;
		this.y = 0;
		this.name = "NULL";
	}
	
	public Element(float x, float y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public float getX() {
		return this.x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return this.x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
