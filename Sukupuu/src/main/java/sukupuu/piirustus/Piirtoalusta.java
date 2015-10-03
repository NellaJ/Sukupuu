package sukupuu.piirustus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Piirtoalusta perii luokan JPanel Muuttujana lista kuvioita jotka Piirtoalusta
 * piirtää
 */
public class Piirtoalusta extends JPanel {

    private ArrayList<Kuvio> kuviot;

    public Piirtoalusta(ArrayList<Kuvio> kuviot) {
        super.setBackground(Color.WHITE);
        this.kuviot = kuviot;
    }

    //Kaikki piirtäminen pitäisi olla täällä!!!
    //Kun kuviot ovat listana, ne voidaan piirtää kerralla. 
    // graphics.setStroke(new BasicStroke(int)); -> saa viivan paksuuden, mutta Graphics 2D pitäisi olla
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2 = (Graphics2D) graphics;
        super.paintComponent(graphics2);
        graphics2.setStroke(new BasicStroke(3));

        for (Kuvio kuvio : kuviot) {
            graphics2.setPaint(Color.BLACK);
            kuvio.piirra(graphics2);
            
            if (kuvio.isVari() == true) {
                graphics2.setPaint(Color.RED);
                kuvio.varita(graphics);
            }
        }
    }

}
