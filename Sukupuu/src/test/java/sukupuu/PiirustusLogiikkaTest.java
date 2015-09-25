package sukupuu;

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

public class PiirustusLogiikkaTest {

    Piirustuslogiikka logiikka;
    ArrayList<Henkilo> henkilot = new ArrayList<>();

    @Before
    public void setUp() {
        Henkilo mies = new Henkilo("M");
        mies.setSukupuoli(Sukupuoli.MIES);
        henkilot.add(mies);
        Henkilo nainen = new Henkilo("N");
        nainen.setSukupuoli(Sukupuoli.NAINEN);
        henkilot.add(nainen);
        logiikka = new Piirustuslogiikka(henkilot);
        
    }

    @Test
    public void miespuolinenNelioksi() {
        //TODO, ei toimi vielä koordinaattimetodien takia
     //   ArrayList<Kuvio> kuviot = logiikka.piirraSukupuolet();
     //   assertTrue(kuviot.get(0) instanceof Nelio);
    }
    
    @Test
    public void naispuolinenMuuttuuYmpyraksi() {
        //TODO
    }
}
