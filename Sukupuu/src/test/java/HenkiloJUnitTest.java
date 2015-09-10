
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sukupuu.sukupuu.Henkilo;


public class HenkiloJUnitTest {

    Henkilo henkilo;

    @Before
    public void setUp() {
        henkilo = new Henkilo("nimi", 0, "sairas", false, "M");
    }

    @Test
    public void konstruktoriToimiiOikein() {
        assertEquals("nimi", henkilo.getNimi());
        assertEquals(0, henkilo.getIka());
        assertEquals("sairas", henkilo.getSairaus());
        assertEquals(false, henkilo.isMutaationKantaja());
        assertEquals("M", henkilo.getSukupuoli());
    }
    
    
    @Test
    public void toinenKonstruktoriToimii() {
        Henkilo henkiloUusi = new Henkilo("nimi");
        assertEquals("nimi", henkiloUusi.getNimi());
        assertEquals(0, henkiloUusi.getIka());
        assertEquals("", henkiloUusi.getSairaus());
        assertEquals(false, henkiloUusi.isMutaationKantaja());
        assertEquals("", henkiloUusi.getSukupuoli());
    }
    
    @Test
    public void sukupolviToimii() {
        String sukupolvi = "sukupolvi";
        henkilo.setSukupolvi(sukupolvi);
        assertEquals(sukupolvi, henkilo.getSukupolvi());
    }
    
    @Test
    public void negatiivinenIka() {
        int ika = -10;
        henkilo.setIka(ika);
        assertEquals(ika, henkilo.getIka());
    }
    
   
}
