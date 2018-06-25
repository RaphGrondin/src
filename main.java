import Model.GameManager;
import View.*;

/** Main Class.
 *
 * @author Pierrick GRAF
 * @author Raphaël GRONDIN
 */
@SuppressWarnings("all")
public class main {

    public static void main(String[] args) {
        // LANCEMENT DU MODELE
        GameManager gm = new GameManager();
        Thread t = new Thread(gm::go);
        t.start();

        new MainWindow();
    }
}
