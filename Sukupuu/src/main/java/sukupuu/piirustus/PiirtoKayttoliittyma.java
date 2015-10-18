package sukupuu.piirustus;

import sukupuu.piirustuslogiikka.Kuvio;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Hourula
 */
public class PiirtoKayttoliittyma implements Runnable {

    private JFrame frame;
    private ArrayList<Kuvio> kuviot;
    private HashMap<Kuvio, String> tekstit;
    private Piirtoalusta piirtoalusta;

    /**
     *
     * @param kuviot
     * @param tekstit
     */
    public PiirtoKayttoliittyma(ArrayList<Kuvio> kuviot, HashMap<Kuvio, String> tekstit) {
        this.kuviot = kuviot;
        this.tekstit = tekstit;
    }

    @Override
    public void run() {
        frame = new JFrame();

        frame.setPreferredSize(new Dimension(1000, 1100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        piirtoalusta = new Piirtoalusta(kuviot, tekstit);
        container.add(piirtoalusta);
    }

    public JFrame getFrame() {
        return frame;
    }

}
