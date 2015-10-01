package sukupuu.sukupuu;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import sukupuu.piirustus.Kuvio;
import sukupuu.piirustus.PiirtoKayttoliittyma;
import sukupuu.piirustus.Piirustuslogiikka;

public class NewMain {

    //Alussa voi testata henkilöluokkaa täältä
    //Käyttäjä siis syöttää henkilöitä ja ne tallennetaan listaan tässä vaiheessa. Vaihtoehtoisesti valmiiksi luotu lista
    //Tämä vaihe tulee varmasti graafiseen käyttöliittymään lopulta
    public static void main(String[] args) {
        ArrayList<Henkilo> ihmislista = new ArrayList<>();

        Henkilo eka = new Henkilo("Isä", 68, "terve", false, Sukupuoli.MIES);
        eka.setSukupolvi(1);
        eka.lisaaLapsi(new Henkilo("Neljäs"));
        eka.lisaaLapsi(new Henkilo("Kuudes"));
        eka.lisaaLapsi(new Henkilo("Seiska"));
        eka.lisaaLapsi(new Henkilo("Kasi"));
        eka.setPuoliso(new Henkilo("Äiti"));
        ihmislista.add(eka);
        Henkilo toka = new Henkilo("Äiti", 65, "Sairas", true, Sukupuoli.NAINEN);
        toka.setSukupolvi(1);
        toka.lisaaLapsi(new Henkilo("Neljäs"));
        toka.lisaaLapsi(new Henkilo("Kuudes"));
        toka.lisaaLapsi(new Henkilo("Seiska"));
        toka.lisaaLapsi(new Henkilo("Kasi"));
        toka.setPuoliso(eka);
        ihmislista.add(toka);
        Henkilo kolmas = new Henkilo("Kolmas", 70, "Sairas", true, Sukupuoli.NAINEN);
        kolmas.setSukupolvi(1);
        ihmislista.add(kolmas);
        Henkilo neljas = new Henkilo("Neljäs", 35, "Terve", false, Sukupuoli.NAINEN);
        neljas.setSukupolvi(2);
        ihmislista.add(neljas);
        Henkilo viides = new Henkilo("Viides", 40, "Terve", false, Sukupuoli.MIES);
        viides.setSukupolvi(2);
        viides.lisaaLapsi(new Henkilo("Ysi"));
        viides.lisaaLapsi(new Henkilo("Kymppi"));
        viides.lisaaLapsi(new Henkilo ("Yksitoista"));
        viides.setPuoliso(new Henkilo ("Kuudes"));
        ihmislista.add(viides);
        Henkilo kuudes = new Henkilo("Kuudes", 45, "Sairas", true, Sukupuoli.NAINEN);
        kuudes.setSukupolvi(2);
        kuudes.lisaaLapsi(new Henkilo("Ysi"));
        kuudes.lisaaLapsi(new Henkilo("Kymppi"));
        kuudes.lisaaLapsi(new Henkilo ("Yksitoista"));
        kuudes.setPuoliso(viides);
        ihmislista.add(kuudes);
        Henkilo seiska = new Henkilo("Seiska", 47, "Terve", false, Sukupuoli.NAINEN);
        seiska.setSukupolvi(2);
        ihmislista.add(seiska);
        Henkilo kasi = new Henkilo("Kasi", 49, "Terve", false, Sukupuoli.MIES);
        kasi.setSukupolvi(2);
        ihmislista.add(kasi);
        Henkilo ysi = new Henkilo("Ysi", 10, "Terve", false, Sukupuoli.NAINEN);
        ysi.setSukupolvi(3);
        ihmislista.add(ysi);
        Henkilo kymppi = new Henkilo("Kymppi", 15, "Terve", false, Sukupuoli.NAINEN);
        kymppi.setSukupolvi(3);
        ihmislista.add(kymppi);
        Henkilo yksitoista = new Henkilo("Yksitoista", 20, "Terve", false, Sukupuoli.MIES);
        yksitoista.setSukupolvi(3);
        ihmislista.add(yksitoista);
       
//        for ( Henkilo lapsi : eka.getLapset()){
//            lapsi.toString();
//        }
       
 
        //HUOM!!! Jälkeläisten lisäämistä while-loopilla kokeiltu, ei onnistunut ainakaan parissa tunnissa (prkl)! Unohda se vaihtoehto!
        //Jotain voisi toki pilkkoa metodeiksi ja lyhentää koodia

        
        //Piirustuslogiikka-luokka siis saa listan henkilöitä (nimi ja sukupuoli), joiden perusteella piirtää tässä vaiheessa ympyrän tai neliön
        
        Piirustuslogiikka logic = new Piirustuslogiikka(ihmislista);
        ArrayList<Kuvio> kuviot = logic.piirraKuviot();     //"Muuttaa" henkilöt kuvioiksi
        //ArrayList<Kuvio> viivat = logic.piirraPuolisoilleViivat();
        
        //kuviot.addAll(viivat);      //yhdistää aiemmat kaksi listaa
        
        PiirtoKayttoliittyma kayttis = new PiirtoKayttoliittyma(kuviot);        //Piirtää ne kuviot
        SwingUtilities.invokeLater(kayttis);
    }

}
