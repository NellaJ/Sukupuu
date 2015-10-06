package sukupuu.sukupuu;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sukupuu.sukupuu.Henkilo;
import sukupuu.sukupuu.Sukupuoli;

public class HenkiloTest {

    Henkilo henkilo;

    @Before
    public void setUp() {
        ArrayList<String> mutaatiot = new ArrayList<String>();
        mutaatiot.add("Mutaatio");
        henkilo = new Henkilo("nimi", 40, true, mutaatiot, Sukupuoli.MIES);
    }

    @Test
    public void konstruktoriAsettaaOikeanNimen() {
        assertEquals("nimi", henkilo.getNimi());

    }

    @Test
    public void konstruktoriLaittaaOikeanIan() {
        assertEquals(40, henkilo.getIka());
    }

    @Test
    public void konstruktoriLaittaaSairaudenOikein() {
        assertEquals(true, henkilo.isSairas());
    }

    @Test
    public void konstruktoriLaittaaMutaationOikein() {
        assertEquals("Mutaatio", henkilo.getMutaatiot().get(0));
    }

    @Test
    public void konstruktoriLaittaaSukupuolenOikein() {
        assertEquals(Sukupuoli.MIES, henkilo.getSukupuoli());
    }

    @Test
    public void toinenKonstruktoriToimii() {
        Henkilo henkiloUusi = new Henkilo("nimi");
        assertEquals("nimi", henkiloUusi.getNimi());
        assertEquals(0, henkiloUusi.getIka());
        assertEquals(false, henkiloUusi.isSairas());
        assertTrue(henkiloUusi.getMutaatiot().isEmpty());
        assertEquals(Sukupuoli.MUU, henkiloUusi.getSukupuoli());
    }

    @Test
    public void sukupolviToimii() {
        int sukupolvi = 1;
        henkilo.setSukupolvi(sukupolvi);
        assertEquals(1, henkilo.getSukupolvi());
    }

    @Test
    public void negatiivinenIka() {
        int ika = -10;
        henkilo.setIka(ika);
        assertEquals(true, henkilo.getIka() >= 0);
    }
    @Test
    public void ikaEiLiianSuuri() {
        int ika = 1000;
        henkilo.setIka(ika);
        assertEquals(true, henkilo.getIka() <= 150);
    }
    @Test
    public void lapsiLisataan() {
        Henkilo lapsi = new Henkilo("Kid");
        henkilo.lisaaLapsi(lapsi);
        assertEquals(false, henkilo.getLapset().isEmpty());
    }
    @Test
    public void puolisoLisataan() {
        Henkilo puoliso = new Henkilo("Puoliso");
        henkilo.setPuoliso(puoliso);
        assertEquals(puoliso, henkilo.getPuoliso());
    }
}
