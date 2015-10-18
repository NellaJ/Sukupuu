package sukupuu.piirustus;

import sukupuu.piirustuslogiikka.Kuvio;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 * Piirtoalusta perii luokan JPanel Muuttujana lista kuvioita jotka Piirtoalusta
 * piirtää
 */
public class Piirtoalusta extends JPanel {

    private ArrayList<Kuvio> kuviot;
    private HashMap<Kuvio, String> tekstit;

    /**
     *
     * @param kuviot
     * @param tekstit
     */
    public Piirtoalusta(ArrayList<Kuvio> kuviot, HashMap<Kuvio, String> tekstit) {
        super.setBackground(Color.WHITE);
        this.kuviot = kuviot;
        this.tekstit = tekstit;
    }

    //Kaikki piirtäminen pitäisi olla täällä!!!
    //Kun kuviot ovat listana, ne voidaan piirtää kerralla. 
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2 = (Graphics2D) graphics;
        super.paintComponent(graphics2);
        graphics2.setStroke(new BasicStroke(3));

        for (Kuvio kuvio : kuviot) {
            graphics2.setPaint(Color.BLACK);
            kuvio.piirra(graphics2);
            
            if (kuvio.onkoVari() == true) {
                graphics2.setPaint(Color.RED);
                kuvio.varita(graphics);
            }
        }
        graphics2.setFont(new Font("TimesRoman", Font.BOLD, 18));
        for (Kuvio kuvio : tekstit.keySet()) {
            graphics2.drawString(tekstit.get(kuvio), kuvio.getX(), (kuvio.getY() + 80));     
        }
        graphics2.setFont(new Font("TimesRoman", Font.BOLD, 25));
        graphics2.drawString("SUKUPUU", 300, 50);
    }

}
