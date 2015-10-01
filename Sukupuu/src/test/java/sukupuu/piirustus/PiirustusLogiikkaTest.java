package sukupuu.piirustus;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sukupuu.piirustus.Kuvio;
import sukupuu.piirustus.Nelio;
import sukupuu.piirustus.Piirustuslogiikka;
import sukupuu.piirustus.Ympyra;
import sukupuu.sukupuu.Henkilo;
import sukupuu.sukupuu.Sukupuoli;

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

    @Test
    public void kuvioLisataanListaan() {
        logiikka.keraaSukupolvet();
        assertTrue(logiikka.getKuviolista().size() > 0);
    }

    @Test
    public void kuvioLisataanHashmapiin() {
        logiikka.keraaSukupolvet();
        assertTrue(logiikka.getHenkilonKuvio().size() > 0);
    }

    @Test
    public void sukupolvenMukaanOikeaYKoordinaatti() {
        logiikka.keraaSukupolvet();
        assertEquals(logiikka.getHenkilonKuvio().get(henkilot.get(1).getNimi()).getY(), logiikka.laskeY(henkilot.get(1)));
    }
   
}
