package Model;

import View.SideMenu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

//@SuppressWarnings("serial")
public class GameManager{
    private static ArrayList<Package> packages;
    private static ArrayList<Drone> drones;
    private static ArrayList<Item> items;
    private static ArrayList<Station> stations;
    private static Time time;
    private static Board board;
    private static int width = 1325;
    private static int height = 710;

    public GameManager() {
        board = new Board();
        time = new Time();
        packages = new ArrayList<>();
        drones = new ArrayList<>();
        items = new ArrayList<>();
        stations = new ArrayList<>();
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

    public ArrayList<String> getDronesName() {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i<drones.size(); i++) {
            res.add(drones.get(i).getName());
        }
        return res;
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
            /*if (getTime().getM()==0 && nbItems() < 20) {
                addItem();
            }*/
            for(Drone drone : drones){

            }
            /*for (int i=0; i<animaux.size();i++) {
                //Case c = p.getCase(animaux.get(i).position.getX(), animaux.get(i).position.getY());
                animaux.get(i).run(animaux, nourritures, t, p.getCases());
                //animaux.get(i).run(animaux,nourritures,t, c);
                //animaux.get(i).modifVitesse(c);
            }*/

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

    public static void addBigDrone()
    {
        /* d = new BigDrone("Big Drone");
        drones.add(d);*/
        createDrone(Integer.toString(nbDrones()+1), 0);
    }

    public static void addLittleDrone()
    {
        /*Drone d = new LittleDrone("Little Drone");
        drones.add(d);*/
        createDrone(Integer.toString(nbDrones()+1), 10);
    }

    public static void addStation() {
        Station s = new Station(2,5);
        stations.add(s);
    }

    public static void createDrone (String name, int size)
    {
        if (size == 10) {
            drones.add(new LittleDrone(name));
        } else {
            drones.add(new BigDrone(name));
        }
        String[] names;
        if (nbDrones() == 0) {
            names = new String[1];
            names[0] = "Aucun Element";
        } else {
            names = new String[nbDrones()];
            for(int i = 0 ; i<nbDrones() ; i++){
                names[i] = GameManager.getDrones().get(i).getName();
            }
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(names);
        SideMenu.getMyList().setModel(model);
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

}