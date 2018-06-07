package Model;

import java.util.ArrayList;
import java.util.Random;

//@SuppressWarnings("serial")
public class GameManager{
    private static ArrayList<Package> packages;
    private static ArrayList<Drone> drones;
    private static Time t;
    private static Plateau p;
    private static int width = 1165;
    private static int height = 615;

    public GameManager() {
        p = new Plateau();
        t = new Time();
        nourritures = new ArrayList<Nourriture>();
        animaux = new ArrayList<Animal>();
    }

    public static ArrayList<Nourriture> getNourritures() {
        return nourritures;
    }
    public static ArrayList<Animal> getAnimaux() {
        return animaux;
    }
    public static Plateau getPlateau() {
        return p;
    }
    public static Time getTemps() {
        return t;
    }

    public static void addNourritures(Nourriture n) {
        nourritures.add(n);
    }

    public static void addAnimaux(Animal a) {
        animaux.add(a);
    }

    public static int nbAnimaux(){
        return animaux.size();
    }

    public static int nbCarnivores()
    {
        int cpt=0;
        for (int i=0;i<animaux.size();i++)
        {
            if(animaux.get(i).IsCarnivore())cpt++;
        }
        return cpt;
    }
    public static int nbHerbivores()
    {
        int cpt=0;
        for (int i=0;i<animaux.size();i++)
        {
            if(animaux.get(i).IsCarnivore()==false)cpt++;
        }
        return cpt;
    }

    public static int nbNourritures()
    {
        return nourritures.size();
    }

    public static int nbViandes()
    {
        int cpt=0;
        for (int i=0;i<nourritures.size();i++)
        {
            if(nourritures.get(i).isViande())cpt++;
        }
        return cpt;
    }
    public static int nbHerbes()
    {
        int cpt=0;
        for (int i=0;i<nourritures.size();i++)
        {
            if(nourritures.get(i).isPlante())cpt++;
        }
        return cpt;
    }

    public void go(){
        for(;;){
            getTemps().setTmp();
            if (getTemps().getM()==0 && nbHerbes() < 20) {
                ajoutHerbe();
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

    public static void ajoutHerbe()
    {
        Nourriture n=new Nourriture(true);
        nourritures.add(n);
    }
    public static void ajoutViande()
    {
        Nourriture n=new Nourriture(false,true,100,"Viande");
        nourritures.add(n);
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