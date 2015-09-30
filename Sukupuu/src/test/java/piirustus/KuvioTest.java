package piirustus;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import piirustus.Nelio;
import piirustus.Viiva;
import piirustus.Ympyra;


public class KuvioTest {
    
    Nelio nelio;
    Ympyra ympyra;
    Viiva viiva;
   
    @Before
    public void setUp() {
        nelio = new Nelio(10, 20, 30);
        ympyra = new Ympyra(40, 50, 60);
        viiva = new Viiva(70, 80, 90, 100);
    }
    
   @Test
   public void konstruktoriAsettaaNelionXKoordinaatinOikein() {
       assertEquals(10, nelio.getX());
   }
   
   @Test
   public void konstruktoriAsettaaNelionYKoordinaatinOikein() {
       assertEquals(20, nelio.getY());
   }
   @Test
   public void konstruktoriAsettaaNelionSivunOikein() {
       assertEquals(30, nelio.getSivunPituus());
   }
    
   @Test
   public void konstruktoriAsettaaYmpyranXKoordinaatinOikein() {
       assertEquals(40, ympyra.getX());
   }
   @Test
   public void konstruktoriAsettaaYmpyranYKoordinaatinOikein() {
       assertEquals(50, ympyra.getY());
   }
   @Test
   public void konstruktoriAsettaaYmpyranHalkaisijanOikein() {
       assertEquals(60, ympyra.getHalkaisija());
   }
   @Test
   public void konstruktoriAsettaaViivanX1Oikein() {
       assertEquals(70, viiva.getX());
   }
   @Test
   public void konstruktoriAsettaaViivanY1Oikein() {
       assertEquals(80, viiva.getY());
   }
   @Test
   public void konstruktoriAsettaaViivanX2Oikein() {
       assertEquals(90, viiva.getX2());
   }
   @Test
   public void konstruktoriAsettaaViivanY2Oikein() {
       assertEquals(100, viiva.getY2());
   }
}   
