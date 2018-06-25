package Model;

import java.util.*;

public class Drone extends Element {
    private float fuel;
    private int score;
    private Package pck;
    private HashMap<Double, Vec> distanceStation;

    public Drone(String name, int size) {
        super(name);
        this.setSize(size);
        Random rnd = new Random();
        int x = rnd.nextInt(GameManager.getWidth() - (int) getSize());
        int y = rnd.nextInt(GameManager.getHeight() - (int) getSize());
        this.setX(x + getSize() / 2);
        this.setY(y + getSize() / 2);
        this.setImage("src/Model/_img/drone/drone.png");
        this.fuel = 20;
        this.score = 0;
        this.distanceStation = new HashMap<>();
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

    public Drone(float x, float y, String name, int size, float fuel, int score) {
        super(x, y, name, size);
        this.setImage("src/Model/_img/drone/drone.png");
        this.fuel = fuel;
        this.score = score;
        this.distanceStation = new HashMap<>();
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getFuel() {
        return this.fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public void move() {
        stay();
        if (getFuel() == 0) {
            crash();
        } else {
            if (pck == null) {
                findPackage();
            } else {
                findStation();
            }
            //findPackage();
            /*if (getFuel() <= 30) {
                findStation();
            } else {
                findStation();
            }*/
        }
        updatePos();
        if(GameManager.getTime().getM()==0) {
            updateEtat();
        }
        stay();
    }

    public void crash() {

        if (pck != null) {
            GameManager.getPackages().add(pck);
        }
        GameManager.getDrones().remove(this);

    }

    public void findPackage() {
        double	d = 1000;
        for(int i=0; i< GameManager.getPackages().size();i++) {
            if(d > Vec.dist(position, GameManager.getPackages().get(i).position)) {
                d=Vec.dist(position, GameManager.getPackages().get(i).position);
                double x=GameManager.getPackages().get(i).getX()-this.getX();
                double y=GameManager.getPackages().get(i).getY()-this.getY();
                Vec v =new Vec(x,y);
                double ang = v.heading();
                speed.mult(0.1);
                acceleration=new Vec(Math.cos(ang),Math.sin(ang));
                acceleration.mult(15);
                if(this.getX()+this.getSize() >= GameManager.getPackages().get(i).getX()
                        && this.getX() <= GameManager.getPackages().get(i).getX()+20
                        && getY()+this.getSize() >= GameManager.getPackages().get(i).getY()
                        && getY() < GameManager.getPackages().get(i).getY()+20) {
                    speed.mult(0.1);;
                    acceleration.mult(0.1);
                    pck = GameManager.getPackages().get(i);
                    GameManager.getPackages().remove(GameManager.getPackages().get(i));
                    this.setImage("src/Model/_img/drone/drone_package.png");
                }
            }
        }

    }

    public void findStation() {
        double min = 100000000;
        double d = 0;
        distanceStation.clear();
        for (Station s : GameManager.getStations()) {
            //distanceStation.put(Math.sqrt(Math.pow(s.getX()-this.getX(),2)+Math.pow(s.getY()-this.getY(),2)),new Vec(s.getX(),s.getY()));
            d = Vec.dist(s.getPosition(),this.getPosition());
            distanceStation.put(d, new Vec(s.getX(),s.getY()));
        }

        for (Map.Entry<Double,Vec> e : distanceStation.entrySet()) {
            if (e.getKey()< min) {
                min = e.getKey();
            }
        }

        Vec v = distanceStation.get(min);
        double ang = v.heading();
        acceleration=new Vec(Math.cos(ang),Math.sin(ang));


    }

    public void separation() {
        for(Drone d : GameManager.getDrones()) {
            double x=getX()-d.getX();
            double y=getY()-d.getY();
            Vec v =new Vec(x,y);
            double ang = v.heading();
            v = new Vec(Math.cos(ang),Math.sin(ang));
            v.mult(0.5);
            acceleration.add(v);
        }
    }

	private void updatePos() {
		speed.add(acceleration);
		position.add(speed);
	}

    public void stay() {

        if (getX() > GameManager.getWidth()-(50+this.getSize())) {
            double start1 = -2;
            double end1 = -1;
            double start2 = 0;
            double end2 = 1;
            double random = new Random().nextDouble();
            double result1 = start1 + (random * (end1 - start1));
            double result2 = start2 + (random * (end2 - start2));
            acceleration= new Vec(result1,result2);
        } else if (getY() > GameManager.getHeight()-(50+this.getSize()) ) {
            double start1 = 0;
            double end1 = 1;
            double start2 = -2;
            double end2 = -1;
            double random = new Random().nextDouble();
            double result1 = start1 + (random * (end1 - start1));
            double result2 = start2 + (random * (end2 - start2));
            acceleration= new Vec(result1,result2);
        } else if (getX() < 50) {
            double start1 = 1;
            double end1 = 2;
            double start2 = 0;
            double end2 = 1;
            double random = new Random().nextDouble();
            double result1 = start1 + (random * (end1 - start1));
            double result2 = start2 + (random * (end2 - start2));
            acceleration= new Vec(result1,result2);
        } else if (getY() < 50) {
            double start1 = 0;
            double end1 = 1;
            double start2 = 1;
            double end2 = 2;
            double random = new Random().nextDouble();
            double result1 = start1 + (random * (end1 - start1));
            double result2 = start2 + (random * (end2 - start2));
            acceleration= new Vec(result1,result2);
        }
    }

    public void onStation(Vec v) {
        //if ()
    }

	public void updateEtat()	{
		if (getFuel() <=0 ) {
			crash();
		}
	}

	/*public void wakeup()
	{

		Random rnd1= new Random();
		int Vx = rnd1.nextInt(7);
		Random rnd2 = new Random();
		int Vy = rnd2.nextInt(7);
		Random rnd3 = new Random();
		int Accx = rnd3.nextInt(7);
		Random rnd4 = new Random();
		int Accy = rnd4.nextInt(7);

		vitesse = new Vec (Vx,Vy);
		acceleration = new Vec (Accx,Accy);
	}*/

	/*public void dormir()
	{
		vitesse.mult(0);
		acceleration.mult(0);

	}*/

	/*public void mourrir(List<Nourriture> nourritures,List<Animal> animaux)
	{
		if(this.getPosition().getX() < GameManager.getLargeur() || this.getPosition().getX() > 0 || this.getPosition().getY() > 0 || this.getPosition().getY() < GameManager.getHauteur())
		{
			Nourriture n =new Nourriture(false,true,caracVitale.getPoids(),"Viande",position);
			nourritures.add(n);
			animaux.remove(this);
		}
	}*/

	/*public void manger(List<Nourriture> nourritures, List <Animal> animaux)
	{
		if(regime == RegimeAlimentaire.Carnivore  )
		{
			double d = 1000;


			for(int i=0; i< nourritures.size();i++)
			{
				if(d > Vec.dist(position, nourritures.get(i).position) && nourritures.get(i).isViande())
				{
					d=Vec.dist(position, nourritures.get(i).position);
					double x=(nourritures.get(i).getPosition().getX()-this.getPosition().getX())+10;
					double y=(nourritures.get(i).getPosition().getY()-getPosition().getY())+10;
					Vec v =new Vec(x,y);
					double ang = v.heading();
					acceleration=new Vec(Math.cos(ang),Math.sin(ang));



					if(this.getPosition().getX()+caracVitale.getTaille() >= nourritures.get(i).getPosition().getX() && this.getPosition().getX() <= nourritures.get(i).getPosition().getX()+20 && getPosition().getY()+caracVitale.getTaille() >= nourritures.get(i).getPosition().getY() && getPosition().getY() < nourritures.get(i).getPosition().getY()+20)
					{

						int valNut=nourritures.get(i).getValeur()-caracVitale.getAppetit();
						caracVitale.setAppetit(caracVitale.getAppetit()-nourritures.get(i).getValeur());
						if(caracVitale.getAppetit()< 0) caracVitale.setAppetit(0);
						nourritures.get(i).setValeur(valNut);
						vitesse.mult(0.1);
						acceleration.mult(0.1);
						if (nourritures.get(i).getValeur()<=0)
						{

							nourritures.remove(nourritures.get(i));
						}
					}
				}
			}
		}else if(regime == RegimeAlimentaire.Herbivore )
		{
			double	d = 1000;


			for(int i=0; i< nourritures.size();i++)
			{
				if(d > Vec.dist(position, nourritures.get(i).position) && nourritures.get(i).isPlante())
				{

					d=Vec.dist(position, nourritures.get(i).position);
					double x=nourritures.get(i).getPosition().getX()-this.getPosition().getX();
					double y=nourritures.get(i).getPosition().getY()-getPosition().getY();
					Vec v =new Vec(x,y);
					double ang = v.heading();
					vitesse.mult(0.1);
					acceleration=new Vec(Math.cos(ang),Math.sin(ang));
					acceleration.mult(15);
					if(this.getPosition().getX()+caracVitale.getTaille() >= nourritures.get(i).getPosition().getX() && this.getPosition().getX() <= nourritures.get(i).getPosition().getX()+20 && getPosition().getY()+caracVitale.getTaille() >= nourritures.get(i).getPosition().getY() && getPosition().getY() < nourritures.get(i).getPosition().getY()+20)
					{

						int valNut=nourritures.get(i).getValeur()-caracVitale.getAppetit();
						caracVitale.setAppetit(caracVitale.getAppetit()-nourritures.get(i).getValeur());
						if(caracVitale.getAppetit()< 0) caracVitale.setAppetit(0);
						nourritures.get(i).setValeur(valNut);
						vitesse.mult(0.1);;
						acceleration.mult(0.1);
						if (nourritures.get(i).getValeur()<=0)
						{

							nourritures.remove(nourritures.get(i));
							//nourritures.get(i)=null;
						}
					}
				}
			}

		}

	}*/

	/*public void separation(ArrayList<Drone> drones) {

			for(Drone d : drones)
			{
				double x=getX()-d.getX();
				double y=getY()-d.getY();
				Vec v =new Vec(x,y);
				double ang = v.heading();
				v = new Vec(Math.cos(ang),Math.sin(ang));
				v.mult(0.5);
				acceleration.add(v);
			}
	}*/



	/*public void escape(List<Animal> animaux)
	{

		for(int i=0;i<animaux.size();i++)
		{

			if(animaux.get(i).regime == RegimeAlimentaire.Carnivore)
			{
				if (Vec.dist(animaux.get(i).position,position) < caracVitale.getTaille() + 20 )
				{
					double x=getPosition().getX()-animaux.get(i).getPosition().getX();
					double y=getPosition().getY()-animaux.get(i).getPosition().getY();
					Vec v =new Vec(x,y);
					double ang = v.heading();
					acceleration= new Vec(Math.cos(ang),Math.sin(ang));

				}

			}
		}
	}*/

	/*void cogner()
	{

		if (getPosition().getX() < 1)
		{
			vitesse.mult(-1,1);
			//acceleration.mult(-1,1);
			caracVitale.setVie(caracVitale.getVie()-10);
		}
		if (getPosition().getX() > GameManager.getLargeur() - caracVitale.getTaille())
		{
			vitesse.mult(-1,1);
			//acceleration.mult(-1,1);
			caracVitale.setVie(caracVitale.getVie()-10);
		}
		if (getPosition().getY() < 1)
		{
			vitesse.mult(1,-1);
			//acceleration.mult(1,-1);
			caracVitale.setVie(caracVitale.getVie()-10);
		}
		if (getPosition().getY() > GameManager.getHauteur() - caracVitale.getTaille())
		{
			vitesse.mult(1,-1);
			//acceleration.mult(1,-1);
			caracVitale.setVie(caracVitale.getVie()-10);
		}
	}*/

	/*public void deplacer(){
		int xmax = GameManager.getWidth();
		int ymax = GameManager.getHeight();
		if (position.getX() > xmax - 25){
			double start1 = -2;
			double end1 = -1;
			double start2 = 0;
			double end2 = 1;
			double random = new Random().nextDouble();
			double result1 = start1 + (random * (end1 - start1));
			double result2 = start2 + (random * (end2 - start2));
			acceleration= new Vec(result1,result2);
		} else if (position.getY() > ymax - 25){
			double start1 = 0;
			double end1 = 1;
			double start2 = -2;
			double end2 = -1;
			double random = new Random().nextDouble();
			double result1 = start1 + (random * (end1 - start1));
			double result2 = start2 + (random * (end2 - start2));
			acceleration= new Vec(result1,result2);
		} else if (position.getX() < 25){
			double start1 = 1;
			double end1 = 2;
			double start2 = 0;
			double end2 = 1;
			double random = new Random().nextDouble();
			double result1 = start1 + (random * (end1 - start1));
			double result2 = start2 + (random * (end2 - start2));
			acceleration= new Vec(result1,result2);
		} else if (position.getY() < 25){
			double start1 = 0;
			double end1 = 1;
			double start2 = 1;
			double end2 = 2;
			double random = new Random().nextDouble();
			double result1 = start1 + (random * (end1 - start1));
			double result2 = start2 + (random * (end2 - start2));
			acceleration= new Vec(result1,result2);
		}
	}

	public void shift(){
		//double d = 1000;
		for (int i=0;i<packages.size();i++){
			if(animaux.get(i).regime != RegimeAlimentaire.Carnivore){
				if ( d > Vec.dist(animaux.get(i).position,position)){
					d = Vec.dist(animaux.get(i).position,position);
					Animal cible=animaux.get(i);
					double x=cible.position.getX()-position.getX();
					double y=cible.position.getY()-position.getY();
					Vec v =new Vec(x,y);
					double ang = v.heading();
					acceleration=new Vec(Math.cos(ang),Math.sin(ang));
					separation(animaux);
					if (Vec.dist(cible.position,position) <= this.caracVitale.getTaille()){
						int degat = caracVitale.attaque()-cible.caracVitale.defense();
						if (degat <=0) {
							degat = 0;
						}
						cible.caracVitale.setVie(cible.caracVitale.getVie()-degat);
						if (cible.caracVitale.getVie()<=0) {
							cible.mourrir(nourritures, animaux);
						}
					}
				}
			}
		}
	}*/

	/*public void fuir(ArrayList<Animal> animaux){
		for(int i=0; i<animaux.size();i++){
			if(animaux.get(i).regime == RegimeAlimentaire.Carnivore){
				if (position.dist(animaux.get(i).position) < this.caracVitale.getTaille() + 50 ){
					double x=position.getX()-animaux.get(i).position.getX();
					double y=position.getY()-animaux.get(i).position.getY();
					Vec v =new Vec(x,y);
					double ang = v.heading();
					acceleration= new Vec(Math.cos(ang),Math.sin(ang));
				}
			}
		}
	}*/

	/*public void changeSpeed(Item i) {
		if ((i.getX()<=getX() && i.getX()+i.getSize()>getX()) && (i.getY()<=getY() && i.getY()+i.getSize()>getY())) {
			if (caracDeplacement.isTerrestre() && c.isAquatique()) {
				vitesse.limit(caracVitale.getVitesseMax()*0.1);
			} else if(caracDeplacement.isAquatique() && c.isTerrestre()) {
				vitesse.limit(caracVitale.getVitesseMax()*0.1);
			}
		} else vitesse.limit(caracVitale.getVitesseMax());
	}*/
}