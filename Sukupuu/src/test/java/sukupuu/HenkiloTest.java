package sukupuu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sukupuu.Henkilo;
import sukupuu.Sukupuoli;

public class HenkiloTest {

    Henkilo henkilo;

    @Before
    public void setUp() {
        henkilo = new Henkilo("nimi", 40, "sairas", true, Sukupuoli.MIES);
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
        assertEquals("sairas", henkilo.getSairaus());
    }

    @Test
    public void konstruktoriLaittaaMutaationOikein() {
        assertEquals(true, henkilo.isMutaationKantaja());
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
        assertEquals("", henkiloUusi.getSairaus());
        assertEquals(false, henkiloUusi.isMutaationKantaja());
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
