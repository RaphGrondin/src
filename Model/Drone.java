package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drone extends Element {
	private float fuel;
	private int score;
	private Package pck;

	public Drone(String name, int size) {
		super(name);
		this.setSize(size);
		Random rnd = new Random();
		int x = rnd.nextInt(GameManager.getWidth()-(int)getSize());
		int y = rnd.nextInt(GameManager.getHeight()-(int)getSize());
		this.setX(x+getSize()/2);
		this.setY(y+getSize()/2);
		this.setImage("Model/_img/drone/drone.png");
		this.fuel = 100;
		this.score = 0;
		this.pck = null;
	}

	public Drone(float x, float y, String name, int size, float fuel, int score) {
		super(x,y,name,size);
		this.setImage("Model/_img/drone/drone.png");
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

	public void move() {
		if(getFuel() != 0) {
			if(this.pck == null) shiftToPackage();
			else shiftToDestination();

		} else {
			crash();
		}
	}

	/*public void move()
	{
		if(getFuel() == 0) {
			crash();
		} else {
			shift(GameManager.getPackages());
		}
			if(caracVitale.getAppetit() >= 60 && regime==RegimeAlimentaire.Carnivore)
			{


			}
			if(caracVitale.getAppetit() >=50)
			{
				manger(nourritures,animaux);
			}
			if (regime==RegimeAlimentaire.Herbivore)
			{
				fuir(animaux);
			}

			cogner();

		}else
		{
			dormir();
			if (regime==RegimeAlimentaire.Herbivore && caracVitale.getFatigue()<=20)
			{
				fuir(animaux);
				rester();
				cogner();

			}
		}

		updatePos(cases);
		if(T.getM()==0) {
			updateEtat(animaux,nourritures);
		}
	}*/

	public void shiftToPackage(){
		double d = 1000;
		for(Package pck : GameManager.getPackages()){
			// voir pour implenter tâche de drone
			if(d > Vec.dist(pck.getPosition(), this.position)) {
				d = Vec.dist(pck.getPosition(), this.position);
				double x = pck.getPosition().getX()-this.position.getX();
				double y = pck.getPosition().getY()-this.position.getY();
				Vec v = new Vec(x,y);
				double ang = v.heading();
				this.acceleration = new Vec(Math.cos(ang), Math.sin(ang));
				if(Vec.dist(pck.getPosition(),this.position) <= this.size) {
					this.pck = pck;
					GameManager.getPackages().remove(pck);
					break;
				}
			}
		}
	}

	public void shiftToDestination(){
		if(Vec.dist(this.pck.getDestination(),this.position) <= this.size){
			this.pck = null;
			this.score ++;
		} else {
			double x = pck.getDestination().getX() - this.position.getX();
			double y = pck.getDestination().getY() - this.position.getY();
			Vec v = new Vec(x,y);
			double ang = v.heading();
			this.acceleration = new Vec(Math.cos(ang), Math.sin(ang));
		}
	}

	/*private void updatePos(List<Case> cases)
	{

		vitesse.add(acceleration);
		for (Case c :cases){
			modifVitesse(c);
		}
		position.add(vitesse);


	}*/

	/*void updateEtat(List<Animal> animaux,List<Nourriture> nourritures)

	{
		if(vitesse.mag()==0)
		{
			caracVitale.setAppetit(caracVitale.getAppetit()+5);
			caracVitale.setFatigue(caracVitale.getFatigue()-10);
		}else
		{
			caracVitale.setAppetit(caracVitale.getAppetit()+10);
			caracVitale.setFatigue(caracVitale.getFatigue()+10);
		}
		if(caracVitale.getAppetit()>=100)
		{
			caracVitale.setAppetit(100);
			caracVitale.setVie(caracVitale.getVie()-10);
		}

		if(caracVitale.getFatigue()>120)
		{
			caracVitale.setFatigue(120);
			caracVitale.setVie(caracVitale.getVie()-10);
		}

		if (caracVitale.getVie() <=0 )
		{
			mourrir(nourritures,animaux);

		}
		if(caracVitale.getFatigue() <=0)
		{
			caracVitale.setFatigue(0);
			reveil();
		}

	}*/

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

		/*if(regime == RegimeAlimentaire.Carnivore)
		{*/
			/*for(Drone d : drones)
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

	public void crash()
	{

		if (pck != null) {
			GameManager.getPackages().add(pck);
		}
		GameManager.getDrones().remove(this);
		if (getX() > GameManager.getWidth()-(50+getSize()) )
		{
			double start1 = -2;
			double end1 = -1;
			double start2 = 0;
			double end2 = 1;
			double random = new Random().nextDouble();
			double result1 = start1 + (random * (end1 - start1));
			double result2 = start2 + (random * (end2 - start2));
			acceleration= new Vec(result1,result2);

		}else if (getY() > GameManager.getWidth()-(50+getSize()) )
		{
			double start1 = 0;
			double end1 = 1;
			double start2 = -2;
			double end2 = -1;
			double random = new Random().nextDouble();
			double result1 = start1 + (random * (end1 - start1));
			double result2 = start2 + (random * (end2 - start2));
			acceleration= new Vec(result1,result2);

		}else if (getX() < 50)
		{
			double start1 = 1;
			double end1 = 2;
			double start2 = 0;
			double end2 = 1;
			double random = new Random().nextDouble();
			double result1 = start1 + (random * (end1 - start1));
			double result2 = start2 + (random * (end2 - start2));
			acceleration= new Vec(result1,result2);

		}else if (getY() < 50)
		{
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
			if(drones.get(i).regime != RegimeAlimentaire.Carnivore){
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
