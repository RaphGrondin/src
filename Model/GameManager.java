package Model;

import View.SideMenu;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 */
public class GameManager{
    private static ArrayList<Package> packages;
    private static ArrayList<Drone> drones;
    private static ArrayList<Item> items;
    private static ArrayList<Station> stations;
    private static Time time;
    private static Board board;
    private static int width = 1325;
    private static int height = 710;

    /**
     *
     */
    public GameManager() {
        board = new Board();
        time = new Time();
        packages = new ArrayList<>();
        drones = new ArrayList<>();
        items = new ArrayList<>();
        stations = new ArrayList<>();
        addStation(25,50);
        addStation(25,575);
        addStation(1175,50);
        addStation(1175,575);
    }

    /**
     *
     * @return
     */
    public static ArrayList<Package> getPackages() {
        return packages;
    }

    /**
     *
     * @return
     */
    public static ArrayList<Drone> getDrones() {
        return drones;
    }

    /**
     *
     * @return
     */
    public static ArrayList<Item> getItems() {
        return items;
    }

    /**
     *
     * @return
     */
    public static ArrayList<Station> getStations() {
        return stations;
    }

    /**
     *
     * @return
     */
    public static Board getBoard() {
        return board;
    }

    /**
     *
     * @return
     */
    public static Time getTime() {
        return time;
    }

    /**
     *
     * @return
     */
    public static int nbPackages(){
        return packages.size();
    }

    /**
     *
     * @return
     */
    public static int nbDrones(){
        return drones.size();
    }

    /**
     *
     * @return
     */
    public static int nbItems(){
        return items.size();
    }

    /**
     *
     * @return
     */
    public static int nbStations(){
        return stations.size();
    }

    /**
     *
     */
    @SuppressWarnings("static-method")
    public void go(){
        for(;;){
            getTime().running();
            for (int i=0; i<drones.size();i++) {
                drones.get(i).move();
            }
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     */
    public static void addItem()
    {
        Item i = new Item("Item"); //$NON-NLS-1$
        items.add(i);
    }

    /**
     *
     */
    public static void addBigPackage()
    {
        Package p = new BigPackage("Big Package"); //$NON-NLS-1$
        packages.add(p);
    }

    /**
     *
     */
    public static void addLittlePackage()
    {
        Package p = new LittlePackage("Little Package"); //$NON-NLS-1$
        packages.add(p);
    }

    /**
     *
     */
    public static void addBigDrone()
    {
        createDrone(Integer.toString(nbDrones()+1), 100);
    }

    /**
     *
     */
    public static void addLittleDrone()
    {
        createDrone(Integer.toString(nbDrones()+1), 50);
    }

    /**
     *
     * @param x
     * @param y
     */
    public static void addStation(int x, int y) {
        Station s = new Station(2,5, x ,y);
        stations.add(s);
    }

    /**
     *
     * @param name
     * @param size
     */
    public static void createDrone (String name, int size)
    {
        if (size == 50) {
            drones.add(new LittleDrone(name));
        } else {
            drones.add(new BigDrone(name));
        }
        updateList();
    }

    /**
     *
     */
    private static void updateList(){
        String[] names;
        if (nbDrones() == 0) {
            names = new String[1];
            names[0] = "Aucun Element"; //$NON-NLS-1$
        } else {
            names = new String[nbDrones()];
            for(int i = 0 ; i<nbDrones() ; i++){
                names[i] = GameManager.getDrones().get(i).getName();
            }
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(names);
        SideMenu.getMyList().setModel(model);
    }

    /**
     *
     * @param name
     */
    public static void removeDrone(String name){
        for(int i = 0 ; i<nbDrones() ; i++){
            if(drones.get(i).getName().equals(name)){
                drones.remove(i);
                updateList();
            }
        }
    }

    /**
     *
     * @return
     */
    public static int getWidth() {
        return width;
    }

    /**
     *
     * @return
     */
    public static int getHeight() {
        return height;
    }

}