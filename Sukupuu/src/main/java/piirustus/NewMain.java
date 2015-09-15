package piirustus;

import java.awt.Graphics;
import javax.swing.SwingUtilities;

public class NewMain {

    public static void main(String[] args) {
        //Piirtämisen testaamista täällä, koko pakkaus vielä työn alla!!!

        Ympyra ympyra = new Ympyra(50, 50, 50);
        
        PiirtoKayttoliittyma kayttis = new PiirtoKayttoliittyma(ympyra);
        SwingUtilities.invokeLater(kayttis);

    }

}
