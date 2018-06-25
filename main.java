import Model.GameManager;
import View.*;

/**
 *
 * @author Pierrick
 *
 */
public class main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // LANCEMENT DU MODELE
        GameManager gm = new GameManager();
        Thread t = new Thread(gm::go);
        t.start();

        new MainWindow();
    }
}
