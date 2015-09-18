package piirustus;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class NewMain {

    public static void main(String[] args) {
        //Piirtämisen testaamista täällä käyttöliittymän puuttuessa, koko pakkaus vielä työn alla!!!
        //Useiden kuvioiden piirtämiseen toimii ainakin niiden lisääminen listana
        ArrayList<Kuvio> kuviot = new ArrayList();
        Ympyra ympyra = new Ympyra(50, 50, 50);
        kuviot.add(ympyra);
        Ympyra ympyra2 = new Ympyra(200, 200, 50);
        kuviot.add(ympyra2);
        Nelio nelio1 = new Nelio(50, 200, 50);
        kuviot.add(nelio1);
        Nelio nelio2 = new Nelio(200, 50, 50);
        kuviot.add(nelio2);
        Viiva viiva = new Viiva(75, 75, 200, 75);
        kuviot.add(viiva);
        
        PiirtoKayttoliittyma kayttis = new PiirtoKayttoliittyma(kuviot);
        SwingUtilities.invokeLater(kayttis);

    }

}
