package piirustus;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class PiirtoKayttoliittyma implements Runnable {

    private JFrame frame;
    private Kuvio kuvio;
    private Piirtoalusta piirtoalusta;

    public PiirtoKayttoliittyma(Kuvio kuvio) {
        this.kuvio = kuvio;
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension (400, 400));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        piirtoalusta = new Piirtoalusta(kuvio);
        container.add(piirtoalusta);
    }

    public JFrame getFrame() {
        return frame;
    }

}
