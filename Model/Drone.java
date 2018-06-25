package Model;

import java.util.*;

/**
 *
 */
public class Drone extends Element {
    private float fuel;
    private int score;
    private Package pck;

    /**
     *
     * @param name
     * @param size
     */
    public Drone(String name, int size) {
        super(name);
        this.setSize(size);
        Random rnd = new Random();
        int x = rnd.nextInt(GameManager.getWidth() - (int) getSize());
        int y = rnd.nextInt(GameManager.getHeight() - (int) getSize());
        this.setX(x + getSize() / 2);
        this.setY(y + getSize() / 2);
        this.setImage("src/Model/_img/drone/drone.png"); //$NON-NLS-1$
        this.fuel = 20;
        this.score = 0;
        Random rnd1= new Random();
        int Vx = rnd1.nextInt(7);
        Random rnd2 = new Random();
        int Vy = rnd2.nextInt(7);
        Random rnd3 = new Random();
        int Accx = rnd3.nextInt(7);
        Random rnd4 = new Random();
        int Accy = rnd4.nextInt(7);
        this.speed = new Vec(Vx,Vy);
        this.acceleration = new Vec (Accx,Accy);
    }

    /**
     *
     * @param x
     * @param y
     * @param name
     * @param size
     * @param fuel
     * @param score
     */
    public Drone(float x, float y, String name, int size, float fuel, int score) {
        super(x, y, name, size);
        this.setImage("src/Model/_img/drone/drone.png"); //$NON-NLS-1$
        this.fuel = fuel;
        this.score = score;
    }

    /**
     *
     * @return
     */
    public int getScore() {
        return this.score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @return
     */
    public float getFuel() {
        return this.fuel;
    }

    /**
     *
     * @param fuel
     */
    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    /**
     *
     */
    public void move() {
        stay();
        if (getFuel() == 0) {
            crash();
        } else {
            if (this.getFuel()<=30) {
                findStation();
            }

            if (this.pck == null) {
                findPackage();
            } else {
                findStation();
            }
        }
        updatePos();
        if(GameManager.getTime().getM()==0) {
            updateState();
        }

    }

    /**
     *
     */
    public void crash() {

        if (this.pck != null) {
            this.pck.setX(getX());
            this.pck.setY(getY());
            GameManager.getPackages().add(this.pck);
        }
        GameManager.getDrones().remove(this);

    }

    /**
     *
     */
    public void findPackage() {
        double	d = 10000000;
        for(int i=0; i< GameManager.getPackages().size();i++) {
            if (this instanceof LittleDrone) {
                if (GameManager.getPackages().get(i) instanceof LittlePackage) {
                    findClosestPackage(i, d);
                }
            } else {
                findClosestPackage(i, d);
            }
        }
    }

    /**
     *
     * @param i
     * @param d
     * @return
     */
    public double findClosestPackage(int i, double d){
        if(d > Vec.dist(this.position, GameManager.getPackages().get(i).position)) {
            d=Vec.dist(this.position, GameManager.getPackages().get(i).position);
            double x=GameManager.getPackages().get(i).getX()-this.getX();
            double y=GameManager.getPackages().get(i).getY()-this.getY();
            Vec v =new Vec(x,y);
            double ang = v.heading();
            this.speed.mult(0.1);
            this.acceleration=new Vec(Math.cos(ang),Math.sin(ang));
            this.acceleration.mult(15);
            if(this.getX()+this.getSize() >= GameManager.getPackages().get(i).getX()
                    && this.getX() <= GameManager.getPackages().get(i).getX()+20
                    && getY()+this.getSize() >= GameManager.getPackages().get(i).getY()
                    && getY() < GameManager.getPackages().get(i).getY()+20) {
                this.speed.mult(0.1);
                this.acceleration.mult(0.1);
                this.pck = GameManager.getPackages().get(i);
                GameManager.getPackages().remove(GameManager.getPackages().get(i));
                this.setImage("src/Model/_img/drone/drone_package.png"); //$NON-NLS-1$
            }
        }
        return d;
    }

    /**
     *
     */
    public void findStation() {
        double	d = 10000000;
        for(int i=0; i< GameManager.getStations().size();i++) {
            if(d > Vec.dist(this.position, GameManager.getStations().get(i).position)) {
                d=Vec.dist(this.position, GameManager.getStations().get(i).position);
                double x=GameManager.getStations().get(i).getX()-this.getX();
                double y=GameManager.getStations().get(i).getY()-this.getY();
                Vec v =new Vec(x,y);
                double ang = v.heading();
                this.speed.mult(0.1);
                this.acceleration=new Vec(Math.cos(ang),Math.sin(ang));
                this.acceleration.mult(15);
                if(this.getX()+this.getSize() >= GameManager.getStations().get(i).getX()
                        && this.getX() <= GameManager.getStations().get(i).getX()+20
                        && getY()+this.getSize() >= GameManager.getStations().get(i).getY()
                        && getY() < GameManager.getStations().get(i).getY()+20) {
                    this.speed.mult(0.1);
                    this.acceleration.mult(0.1);
                    this.pck = null;
                    this.setImage("src/Model/_img/drone/drone.png"); //$NON-NLS-1$
                    this.setFuel(100);
                }
            }
        }
    }

    /**
     *
     */
	private void updatePos() {
        this.speed.add(this.acceleration);
        this.speed.limit(7);
        this.position.add(this.speed);
        this.acceleration.mult(0);
	}

    /**
     *
     */
    public void stay() {

        if (getX() > GameManager.getWidth()-(50+this.getSize())) {
            double start1 = -2;
            double end1 = -1;
            double start2 = 0;
            double end2 = 1;
            double random = new Random().nextDouble();
            double result1 = start1 + (random * (end1 - start1));
            double result2 = start2 + (random * (end2 - start2));
            this.acceleration= new Vec(result1,result2);
        } else if (getY() > GameManager.getHeight()-(50+this.getSize()) ) {
            double start1 = 0;
            double end1 = 1;
            double start2 = -2;
            double end2 = -1;
            double random = new Random().nextDouble();
            double result1 = start1 + (random * (end1 - start1));
            double result2 = start2 + (random * (end2 - start2));
            this.acceleration= new Vec(result1,result2);
        } else if (getX() < 50) {
            double start1 = 1;
            double end1 = 2;
            double start2 = 0;
            double end2 = 1;
            double random = new Random().nextDouble();
            double result1 = start1 + (random * (end1 - start1));
            double result2 = start2 + (random * (end2 - start2));
            this.acceleration= new Vec(result1,result2);
        } else if (getY() < 50) {
            double start1 = 0;
            double end1 = 1;
            double start2 = 1;
            double end2 = 2;
            double random = new Random().nextDouble();
            double result1 = start1 + (random * (end1 - start1));
            double result2 = start2 + (random * (end2 - start2));
            this.acceleration= new Vec(result1,result2);
        }
    }

	public void updateState()	{

        if(this.getFuel()>=100) {
            this.setFuel(100);
        }
        this.setFuel(this.getFuel()-10);
		if (getFuel() <=0 ) {
			crash();
		}
	}
}