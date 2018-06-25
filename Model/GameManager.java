package Model;

import View.SideMenu;
import javax.swing.*;
import java.util.ArrayList;

/** Implements the GameManager, which handles the creating and updating
 * of the different elements (drones, items, packages, stations). It also
 * handles the events according to the time.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
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

    /** Constructor of the GameManager. Initializes a board and time and adds
     * 4 stations to the board.
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

    /** Getter of the package list.
     *
     * @return return the list of current Packages waiting to be picked up.
     */
    public static ArrayList<Package> getPackages() {
        return packages;
    }

    /** Getter of the drone list.
     *
     * @return return the list of drones currently operating.
     */
    public static ArrayList<Drone> getDrones() {
        return drones;
    }

    /** Getter of the item list.
     *
     * @return return the list of items currently on the board.
     */
    public static ArrayList<Item> getItems() {
        return items;
    }

    /** Getter of the station list.
     *
     * @return return the stations currently on the board.
     */
    public static ArrayList<Station> getStations() {
        return stations;
    }

    /** Getter of the board.
     *
     * @return return the current board.
     */
    public static Board getBoard() {
        return board;
    }

    /** Getter of the time.
     *
     * @return return the current time.
     */
    public static Time getTime() {
        return time;
    }

    /** Computes the number of packages currently on the board.
     *
     * @return return the size of the list of packages.
     */
    public static int nbPackages(){
        return packages.size();
    }

    /** Computes the number of drones currently on the board.
     *
     * @return return the size of the list of drones.
     */
    public static int nbDrones(){
        return drones.size();
    }

    /** Computes the number of items currently on the board.
     *
     * @return return the size of the list of items.
     */
    public static int nbItems(){
        return items.size();
    }

    /** Computes the number of stations currently on the board.
     *
     * @return return the size of the list of stations.
     */
    public static int nbStations(){
        return stations.size();
    }

    /** Method that is run by the Main class. This method starts the simulation and calls to the
     * updates of the drones' position.
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

    /** Create a new Item and add it to the list of items.
     *
     */
    public static void addItem()
    {
        Item i = new Item("Item"); //$NON-NLS-1$
        items.add(i);
    }

    /** Create a new BigPackage and add it to the list of packages.
     *
     */
    public static void addBigPackage()
    {
        Package p = new BigPackage("Big Package"); //$NON-NLS-1$
        packages.add(p);
    }

    /** Create a new LittlePackage and add it to the list of packages.
     *
     */
    public static void addLittlePackage()
    {
        Package p = new LittlePackage("Little Package"); //$NON-NLS-1$
        packages.add(p);
    }

    /** Create a new BigDrone and add it to the list of drones.
     *
     */
    public static void addBigDrone()
    {
        createDrone(Integer.toString(nbDrones()+1), 100);
    }

    /** Create a new LittleDrone and add it to the list of drones.
     *
     */
    public static void addLittleDrone()
    {
        createDrone(Integer.toString(nbDrones()+1), 50);
    }

    /** Create a new Station and add it to the list of stations.
     *
     * @param x X coordinate of the station to be created.
     * @param y Y coordinate of the station to be created.
     */
    public static void addStation(int x, int y) {
        Station s = new Station(2,5, x ,y);
        stations.add(s);
    }

    /** Create a new Drone and add it to the list of stations.
     *
     * @param name the name of the drone to be created.
     * @param size the size of the drone to be created.
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

    /** Updates the list for the ComboBox menu of drones in the SideMenu.
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

    /** Delete a drone and remove it from the list of drones.
     *
     * @param name name of the drone to identify it.
     */
    public static void removeDrone(String name){
        for(int i = 0 ; i<nbDrones() ; i++){
            if(drones.get(i).getName().equals(name)){
                drones.remove(i);
                updateList();
            }
        }
    }

    /** Getter of the width of the GameManager.
     *
     * @return return the width of the GameManager.
     */
    public static int getWidth() {
        return width;
    }

    /** Getter of the width of the GameManager.
     *
     * @return return the height of the GameManager.
     */
    public static int getHeight() {
        return height;
    }

}