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
   
    @Test
    public void laskeeXOikein() {
        assertEquals(logiikka.laskeX(3), 700);
    }
    
    @Test
    public void laskeeYOikein() {
        Henkilo tyyppi = new Henkilo("Tyyppi", 20, null, true, Sukupuoli.MIES);
        tyyppi.setSukupolvi(4);
        assertEquals(logiikka.laskeY(tyyppi), 800);
    }
    @Test
    public void korkeusOikein() {
        assertEquals(logiikka.laskeKorkeus(), 60);
    }
    
    @Test
    public void toinenXMetodiToimiiOikein() {
        Henkilo mies2 = new Henkilo("M2", 40, "Sairas", true, Sukupuoli.MIES);    //indeksi 0
        mies2.setSukupolvi(1);
        Henkilo nainen2 = new Henkilo("N2", 30, "Terve", false, Sukupuoli.NAINEN); //indeksi 1
        nainen2.setSukupolvi(1);
        mies2.setPuoliso(nainen2);
        nainen2.setPuoliso(mies2);
        henkilot.add(mies2);    //indeksi 2
        henkilot.add(nainen2);  //indeksi 3
        logiikka = new Piirustuslogiikka(henkilot);
        logiikka.keraaSukupolvet();
        assertEquals(logiikka.kuvionXViivanKoordinaatiksi(nainen2), 730);
    }
    @Test
    public void toinenYMetodiToimiiOikein() {
        Henkilo mies2 = new Henkilo("M2", 40, "Sairas", true, Sukupuoli.MIES);    //indeksi 0
        mies2.setSukupolvi(3);
        Henkilo nainen2 = new Henkilo("N2", 30, "Terve", false, Sukupuoli.NAINEN); //indeksi 1
        nainen2.setSukupolvi(3);
        mies2.setPuoliso(nainen2);
        nainen2.setPuoliso(mies2);
        henkilot.add(mies2);    //indeksi 2
        henkilot.add(nainen2);  //indeksi 3
        logiikka = new Piirustuslogiikka(henkilot);
        logiikka.keraaSukupolvet();
        assertEquals(logiikka.kuvionYViivanKoordinaatiksi(mies2), 630);
    }
}
