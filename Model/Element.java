package Model;

public class Element {
	private float x;
	private float y;
	private String name;
	private int size;
	
	public Element() {
		this.x = 0;
		this.y = 0;
		this.name = "NULL";
		this.size = 0;
	}
	
	public Element(float x, float y, String name, int size) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.size = size;
	}
	
	
	public float getX() {
		return this.x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return this.y;
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
	
	public float getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
}
