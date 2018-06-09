package Model;

import java.util.ArrayList;
import java.util.Random;

//@SuppressWarnings("serial")
public class GameManager{
    private static ArrayList<Package> packages;
    private static ArrayList<Drone> drones;
    private static ArrayList<Item> items;
    private static ArrayList<Station> stations;
    private static Time time;
    private static Board board;
    private static int width = 1165;
    private static int height = 615;

    public GameManager() {
        board = new Board();
        time = new Time();
        packages = new ArrayList<Package>();
        drones = new ArrayList<Drone>();
        items = new ArrayList<Item>();
        stations = new ArrayList<Station>();
    }

    public static ArrayList<Package> getPackages() {
        return packages;
    }
    public static ArrayList<Drone> getDrones() {
        return drones;
    }
    public static ArrayList<Item> getItems() {
        return items;
    }
    public static ArrayList<Station> getStations() {
        return stations;
    }
    public static Board getBoard() {
        return board;
    }
    public static Time getTime() {
        return time;
    }

    public static void addPackage(Package p) {
        packages.add(p);
    }

    public static void addItem(Item i) {
        items.add(i);
    }

    public static void addDrone(Drone d) {
        drones.add(d);
    }

    public static void addStation(Station s) {
        stations.add(s);
    }

    public static int nbPackages(){
        return packages.size();
    }
    public static int nbDrones(){
        return drones.size();
    }
    public static int nbItems(){
        return items.size();
    }
    public static int nbStations(){
        return stations.size();
    }

    public void go(){
        for(;;){
            getTime().setTmp();
            if (getTime().getM()==0 && nbItems() < 20) {
                addItem();
            }
            for (int i=0; i<animaux.size();i++) {
                //Case c = p.getCase(animaux.get(i).position.getX(), animaux.get(i).position.getY());
                animaux.get(i).run(animaux, nourritures, t, p.getCases());
                //animaux.get(i).run(animaux,nourritures,t, c);
                //animaux.get(i).modifVitesse(c);
            }

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addItem()
    {
        Item i = new Item("Item");
        items.add(i);
    }
    public static void addBigPackage()
    {
        Package p = new BigPackage("Big Package");
        packages.add(p);
    }

    public static void addLittlePackage()
    {
        Package p = new LittlePackage("Little Package");
        packages.add(p);
    }

    public void ajoutNourriture(Nourriture n)
    {

        nourritures.add(n);
    }

    public static void ajoutHerbivore()
    {
        boolean diurne;
        int vitMax=10;
        int vitMin=2;
        int poidsMax=100;
        int poidsMin=10;
        int tailleMax=30;
        int tailleMin=10;
        Random rnd = new Random();
        int r = rnd.nextInt(100);
        if(r<=75)
        {
            diurne=true;
        }else diurne=false;
        Random randV = new Random();
        int vitesse = randV.nextInt(vitMax - vitMin + 1) + vitMin;
        Random randP = new Random();
        int poids = randP.nextInt(poidsMax - poidsMin + 1) + poidsMin;
        Random randT = new Random();
        int taille = randT.nextInt(tailleMax - tailleMin + 1) + tailleMin;
        Animal a=new Animal(vitesse,poids,taille,false,diurne);
        animaux.add(a);


    }

    public static void ajoutCarnivore()
    {

        boolean diurne;
        int vitMax=10;
        int vitMin=2;
        int poidsMax=100;
        int poidsMin=10;
        int tailleMax=30;
        int tailleMin=10;
        Random rnd = new Random();
        int r = rnd.nextInt(100);
        if(r<=75)
        {
            diurne=true;
        }else diurne=false;
        Random randV = new Random();
        int vitesse = randV.nextInt(vitMax - vitMin + 1) + vitMin;
        Random randP = new Random();
        int poids = randP.nextInt(poidsMax - poidsMin + 1) + poidsMin;
        Random randT = new Random();
        int taille = randT.nextInt(tailleMax - tailleMin + 1) + tailleMin;
        Animal a=new Animal(vitesse,poids,taille,true,diurne);
        animaux.add(a);


    }
    public static void creationAnimal(String nom,boolean carn,boolean diurne,boolean terrestre, boolean aquatique,
                                      boolean aerien,int nbPattes,int poids,int taille,int vitMax,int rouge,int vert,int bleu)

    {
        Animal a=new Animal(nom,carn,diurne,terrestre,aquatique,aerien,nbPattes,poids,taille,vitMax,rouge,vert,bleu);
        animaux.add(a);

    }

    public static int getLargeur() {
        return width;
    }

    public static int getHauteur() {
        return height;
    }

}