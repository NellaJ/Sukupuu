package piirustus;

import java.awt.Color;
import java.awt.Graphics;
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
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Kuvio kuvio : kuviot) {
            kuvio.piirra(graphics);
            // graphics.setColor(Color.red);   //Tällä saa värin muutettua. On tosin väärässä kohdassa (muuttaa vain jälkimmäisten värit)
        }
    }

}
