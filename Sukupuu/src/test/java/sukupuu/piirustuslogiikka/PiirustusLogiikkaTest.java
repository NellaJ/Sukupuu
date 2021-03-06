package sukupuu.piirustuslogiikka;

import sukupuu.piirustuslogiikka.Viiva;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sukupuu.piirustuslogiikka.Kuvio;
import sukupuu.piirustuslogiikka.Nelio;
import sukupuu.piirustuslogiikka.Piirustuslogiikka;
import sukupuu.piirustuslogiikka.Ympyra;
import sukupuu.henkilo.Henkilo;
import sukupuu.henkilo.Sukupuoli;

public class PiirustusLogiikkaTest {

    Piirustuslogiikka logiikka;
    ArrayList<Henkilo> henkilot = new ArrayList<>();
    ArrayList<String> mutaatiotTyhja = new ArrayList<>();

    @Before
    public void setUp() {

        Henkilo mies = new Henkilo("M", 40, true, mutaatiotTyhja, Sukupuoli.MIES);    
        mies.setSukupolvi(1);
        henkilot.add(mies);
        Henkilo nainen = new Henkilo("N", 30, false, mutaatiotTyhja, Sukupuoli.NAINEN); 
        nainen.setSukupolvi(1);
        henkilot.add(nainen);
        logiikka = new Piirustuslogiikka(henkilot);

    }

    @Test
    public void miespuolinenNelioksi() {
        ArrayList<Kuvio> kuviot = logiikka.luoKuviot();
        assertTrue(kuviot.get(0) instanceof Nelio);
    }

    @Test
    public void naispuolinenMuuttuuYmpyraksi() {
        ArrayList<Kuvio> kuviot = logiikka.luoKuviot();
        assertTrue(kuviot.get(1) instanceof Ympyra);
    }

    @Test
    public void kuvioLisataanListaan() {
        logiikka.henkilotKuvioiksi();
        assertTrue(logiikka.getKuviolista().size() > 0);
    }

    @Test
    public void kuvioLisataanHashmapiin() {
        logiikka.henkilotKuvioiksi();
        assertTrue(logiikka.getHenkilonKuvio().size() > 0);
    }

    @Test
    public void sukupolvenMukaanOikeaYKoordinaatti() {
        logiikka.henkilotKuvioiksi();
        assertEquals(logiikka.getHenkilonKuvio().get(henkilot.get(1).getNimi()).getY(), 200);
    }

    @Test
    public void korkeusOikein() {
        assertEquals(logiikka.laskeKorkeus(), 60);
    }

    @Test
    public void toinenXMetodiToimiiOikein() {
        Henkilo mies2 = new Henkilo("M2", 40, true, mutaatiotTyhja, Sukupuoli.MIES);    
        mies2.setSukupolvi(1);
        Henkilo nainen2 = new Henkilo("N2", 30, false, mutaatiotTyhja, Sukupuoli.NAINEN); 
        nainen2.setSukupolvi(1);
        mies2.setPuoliso(nainen2);
        nainen2.setPuoliso(mies2);
        henkilot.add(mies2);    
        henkilot.add(nainen2);  
        logiikka = new Piirustuslogiikka(henkilot);
        logiikka.luoKuviot();
        assertEquals(logiikka.xViivalle(nainen2), 230);
    }

    @Test
    public void toinenYMetodiToimiiOikein() {
        Henkilo mies2 = new Henkilo("M2", 40, true, mutaatiotTyhja, Sukupuoli.MIES);    
        mies2.setSukupolvi(3);
        Henkilo nainen2 = new Henkilo("N2", 30, false, mutaatiotTyhja, Sukupuoli.NAINEN); 
        nainen2.setSukupolvi(3);
        mies2.setPuoliso(nainen2);
        nainen2.setPuoliso(mies2);
        henkilot.add(mies2);    //indeksi 2
        henkilot.add(nainen2);  //indeksi 3
        logiikka = new Piirustuslogiikka(henkilot);
        logiikka.luoKuviot();
        assertEquals(logiikka.yViivalle(mies2), 630);

    }

    @Test
    public void puolisoViivojaEiTuleKuviolistaanJosEiPuolisoa() {
        ArrayList<Henkilo> sinkut = new ArrayList<Henkilo>();
        Henkilo mies = new Henkilo("M", 40, true, mutaatiotTyhja, Sukupuoli.MIES);    
        mies.setSukupolvi(1);
        sinkut.add(mies);
        Henkilo nainen = new Henkilo("N", 30, false, mutaatiotTyhja, Sukupuoli.NAINEN); 
        nainen.setSukupolvi(1);
        sinkut.add(nainen);
        Piirustuslogiikka sinkkuLogiikka = new Piirustuslogiikka(sinkut);

        sinkkuLogiikka.luoKuviot();
        int koko = sinkkuLogiikka.getKuviolista().size();
        sinkkuLogiikka.luoPuolisoViivat();

        assertEquals(koko, sinkkuLogiikka.getKuviolista().size());
    }

    @Test
    public void kuvioidenMaaraEiLisaannyLapsiviivoillaJosEiLapsia() {
        ArrayList<Henkilo> lapsettomat = new ArrayList<Henkilo>();
        Henkilo mies = new Henkilo("M", 40, true, mutaatiotTyhja, Sukupuoli.MIES);    
        mies.setSukupolvi(1);
        Henkilo nainen = new Henkilo("N", 30, false, mutaatiotTyhja, Sukupuoli.NAINEN); 
        nainen.setSukupolvi(1);
        mies.setPuoliso(nainen);
        nainen.setPuoliso(mies);
        lapsettomat.add(mies);
        lapsettomat.add(nainen);
        Piirustuslogiikka lapsetonLogiikka = new Piirustuslogiikka(lapsettomat);
        lapsetonLogiikka.luoKuviot();
        int koko = lapsetonLogiikka.getKuviolista().size();
        lapsetonLogiikka.luoViivatLapsiin();
        
        assertEquals(koko, lapsetonLogiikka.getKuviolista().size());
    }

    @Test
    public void kuvioidenMaaraLisaantyyJosLapsia() {
        ArrayList<Henkilo> lapselliset = luoLapsellistenLista();

        Piirustuslogiikka lapsetLogiikka = new Piirustuslogiikka(lapselliset);

        lapsetLogiikka.luoPuolisoLista();
        lapsetLogiikka.henkilotKuvioiksi();
        int koko = lapsetLogiikka.getKuviolista().size();
        lapsetLogiikka.luoPuolisoViivat();
        lapsetLogiikka.luoViivatLapsiin();

        assertTrue(koko < lapsetLogiikka.getKuviolista().size());
    }

    @Test
    public void ekaLapsiViivaPalauttaaViivan() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();
        assertTrue(logic.ekaLapsiViiva(lista.get(0)) instanceof Viiva);
    }

    @Test
    public void tokaLapsiViivaPalauttaaViivan() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();
        assertTrue(logic.tokaLapsiViiva(lista.get(0)) instanceof Viiva);
    }

    @Test
    public void kolmasLapsiViivaPalauttaaListan() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();
        assertTrue(logic.kolmasLapsiviiva(lista.get(0)) instanceof ArrayList);
    }

    @Test
    public void kolmasLapsiViivaPalauttaaListanJokaEiTyhja() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();
        ArrayList<Viiva> viivalista = logic.kolmasLapsiviiva(lista.get(0));
        assertTrue(viivalista.size() > 0);
    }

    @Test
    public void kolmasLapsiViivaPalauttaaListanJonkaKokoSamaKuinLapsienMaara() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();
        ArrayList<Viiva> viivalista = logic.kolmasLapsiviiva(lista.get(0));
        assertEquals(lista.get(0).getLapset().size(), viivalista.size());
    }

    @Test
    public void ekaLapsiViivaX1Oikein() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();

        assertEquals(logic.ekaLapsiViiva(lista.get(0)).getX(), 80);
    }

    @Test
    public void ekaLapsiViivaY1Oikein() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();

        assertEquals(logic.ekaLapsiViiva(lista.get(0)).getY(), 430); 
    }

    @Test
    public void tokaLapsiViivaX1Oikein() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();

        assertEquals(logic.tokaLapsiViiva(lista.get(0)).getX(), 30);  
    }

    @Test
    public void tokaLapsiViivaY1Oikein() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();

        assertEquals(logic.tokaLapsiViiva(lista.get(0)).getY(), 530);   
    }

    public void kolmasLapsiViivaEkallaLapsellaX1Oikein() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();

        assertEquals(logic.kolmasLapsiviiva(lista.get(0)).get(0).getX(), 530);
    }

    @Test
    public void kolmasLapsiViivaEkallaLapsellaY1Oikein() {
        ArrayList<Henkilo> lista = luoLapsellistenLista();
        Piirustuslogiikka logic = new Piirustuslogiikka(lista);
        logic.luoKuviot();

        assertEquals(logic.kolmasLapsiviiva(lista.get(0)).get(0).getY(), 530);
    }
    
    @Test
    public void koordinaatistoLuodaan() {
        assertTrue(logiikka.getKoordinaatit().size() > 0);
    }

    public ArrayList<Henkilo> luoLapsellistenLista() {
        ArrayList<Henkilo> lapselliset = new ArrayList<Henkilo>();
        Henkilo mies = new Henkilo("M", 40, true, mutaatiotTyhja, Sukupuoli.MIES);   
        mies.setSukupolvi(1);
        Henkilo nainen = new Henkilo("N", 30, false, mutaatiotTyhja, Sukupuoli.NAINEN); 
        nainen.setSukupolvi(1);
        mies.setPuoliso(nainen);
        nainen.setPuoliso(mies);
        Henkilo poika = new Henkilo("M", 4, true, mutaatiotTyhja, Sukupuoli.MIES);    
        poika.setSukupolvi(2);
        Henkilo tytto = new Henkilo("N", 3, false, mutaatiotTyhja, Sukupuoli.NAINEN); 
        nainen.setSukupolvi(2);
        nainen.lisaaLapsi(poika);
        nainen.lisaaLapsi(tytto);
        mies.lisaaLapsi(poika);
        mies.lisaaLapsi(tytto);
        lapselliset.add(mies);
        lapselliset.add(nainen);
        lapselliset.add(poika);
        lapselliset.add(tytto);
        return lapselliset;
    }
}
