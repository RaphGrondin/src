package Model;

public class BigPackage extends Package{

    public BigPackage(String name) {
        super(name);
        this.setValue(100);
    }

    public BigPackage(float x, float y, String name, int size) {
        super(x, y, name, size, 100);
        // TODO Auto-generated constructor stub
    }
}
