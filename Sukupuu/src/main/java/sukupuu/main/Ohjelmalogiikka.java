package sukupuu.main;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.SwingUtilities;
import sukupuu.GraafinenKayttis.Graafinen;
import sukupuu.piirustuslogiikka.Kuvio;
import sukupuu.piirustus.PiirtoKayttoliittyma;
import sukupuu.piirustuslogiikka.Piirustuslogiikka;
import sukupuu.henkilo.Henkilo;

/**
 *
 * @author Hourula
 */
public class Ohjelmalogiikka {

    private ArrayList<Henkilo> ihmislista;

    /**
     * Saa parametrina ArrayListin Henkiloita.
     *
     * @param lista
     */
    public Ohjelmalogiikka(ArrayList<Henkilo> lista) {
        this.ihmislista = lista;
        start();
    }

    private void start() {

        Piirustuslogiikka logic = new Piirustuslogiikka(ihmislista);
        ArrayList<Kuvio> kuviot = logic.luoKuviot();     

        HashMap<Kuvio, String> tekstit = logic.teeStringLista();

        PiirtoKayttoliittyma kayttis = new PiirtoKayttoliittyma(kuviot, tekstit);       
        SwingUtilities.invokeLater(kayttis);
    }
}
