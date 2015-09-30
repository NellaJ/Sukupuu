package piirustus;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import piirustus.Kuvio;
import piirustus.Nelio;
import piirustus.Piirustuslogiikka;
import piirustus.Ympyra;
import sukupuu.Henkilo;
import sukupuu.Sukupuoli;

public class PiirustusLogiikkaTest {

    Piirustuslogiikka logiikka;
    ArrayList<Henkilo> henkilot = new ArrayList<>();

    @Before
    public void setUp() {
        Henkilo mies = new Henkilo("M", 40, "Sairas", true, Sukupuoli.MIES);    //indeksi 0
        mies.setSukupolvi(1);
        henkilot.add(mies);
        Henkilo nainen = new Henkilo("N", 30, "Terve", false, Sukupuoli.NAINEN); //indeksi 1
        nainen.setSukupolvi(1);
        henkilot.add(nainen);
        logiikka = new Piirustuslogiikka(henkilot);

    }

    @Test
    public void miespuolinenNelioksi() {
        ArrayList<Kuvio> kuviot = logiikka.piirraKuviot();
        assertTrue(kuviot.get(0) instanceof Nelio);
    }

    @Test
    public void naispuolinenMuuttuuYmpyraksi() {
        ArrayList<Kuvio> kuviot = logiikka.piirraKuviot();
        assertTrue(kuviot.get(1) instanceof Ympyra);
    }

   
}
