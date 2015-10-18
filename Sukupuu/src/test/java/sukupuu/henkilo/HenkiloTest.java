package sukupuu.henkilo;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sukupuu.henkilo.Henkilo;
import sukupuu.henkilo.Sukupuoli;

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
    public void konstruktoriAsettaaOikeanIan() {
        assertEquals(40, henkilo.getIka());
    }

    @Test
    public void konstruktoriAsettaaHenkilonSairaaksi() {
        assertEquals(true, henkilo.onkoSairas());
    }

    @Test
    public void konstruktoriAsettaaMutaation() {
        assertEquals("Mutaatio", henkilo.getMutaatiot().get(0));
    }

    @Test
    public void konstruktoriAsettaaOikeanSukupuolen() {
        assertEquals(Sukupuoli.MIES, henkilo.getSukupuoli());
    }

    @Test
    public void toinenKonstruktoriToimii() {
        Henkilo henkiloUusi = new Henkilo("nimi");
        assertEquals("nimi", henkiloUusi.getNimi());
        assertEquals(0, henkiloUusi.getIka());
        assertEquals(false, henkiloUusi.onkoSairas());
        assertTrue(henkiloUusi.getMutaatiot().isEmpty());
        assertEquals(Sukupuoli.MUU, henkiloUusi.getSukupuoli());
    }

    @Test
    public void setteriAsettaaOikeanSukupolven() {
        int sukupolvi = 3;
        henkilo.setSukupolvi(sukupolvi);
        assertEquals(3, henkilo.getSukupolvi());
    }

    @Test
    public void negatiivinenIkaAsettuuNollaksi() {
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
