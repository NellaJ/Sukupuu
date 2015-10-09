package sukupuu.piirustus;

import sukupuu.piirustuslogiikka.Kuvio;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class PiirtoKayttoliittyma implements Runnable {

    private JFrame frame;
    private ArrayList<Kuvio> kuviot;
    private Piirtoalusta piirtoalusta;

    public PiirtoKayttoliittyma(ArrayList<Kuvio> kuviot) {
        this.kuviot = kuviot;
    }

    @Override
    public void run() {
        frame = new JFrame();

        frame.setPreferredSize(new Dimension(1000, 1000));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        piirtoalusta = new Piirtoalusta(kuviot);
        container.add(piirtoalusta);
    }

    public JFrame getFrame() {
        return frame;
    }

}
