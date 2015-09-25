package sukupuu;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import piirustus.Kuvio;
import piirustus.PiirtoKayttoliittyma;
import piirustus.Piirustuslogiikka;

public class NewMain {

    //Alussa voi testata henkilöluokkaa täältä
    //Käyttäjä siis syöttää henkilöitä ja ne tallennetaan listaan tässä vaiheessa. Vaihtoehtoisesti valmiiksi luotu lista
    //Tämä vaihe tulee varmasti graafiseen käyttöliittymään lopulta
    public static void main(String[] args) {
        ArrayList<Henkilo> ihmislista = new ArrayList<>();

        Henkilo eka = new Henkilo("Maija");
        eka.setSukupuoli(Sukupuoli.NAINEN);
        eka.setSukupolvi("I");
        ihmislista.add(eka);
        Henkilo toka = new Henkilo("Matti");
        toka.setSukupuoli(Sukupuoli.MIES);
        toka.setSukupolvi("I");
        ihmislista.add(toka);
        Henkilo kolmas = new Henkilo("Sanna");
        kolmas.setSukupuoli(Sukupuoli.NAINEN);
        kolmas.setSukupolvi("II");
        ihmislista.add(kolmas);
        Henkilo neljas = new Henkilo("Minna");
        neljas.setSukupuoli(Sukupuoli.NAINEN);
        neljas.setSukupolvi("II");
        ihmislista.add(neljas);
        Henkilo viides = new Henkilo("Mika");
        viides.setSukupuoli(Sukupuoli.MIES);
        viides.setSukupolvi("II");
        ihmislista.add(viides);
        
        eka.lisaaLapsi(viides);
        eka.lisaaLapsi(neljas);
        eka.setPuoliso(toka);
        for ( Henkilo lapsi : eka.getLapset()){
            lapsi.toString();
        }
        eka.getPuoliso().toString();
 //       for (Henkilo ihminen : ihmislista) {
 //           ihminen.toString();
  //      }
//        Scanner lukija = new Scanner(System.in);
//        System.out.println("Anna ensimmäinen sukupolvi! Äidin nimi: ");
//        String nimi = lukija.nextLine();
//        Henkilo aiti = new Henkilo(nimi);
//        System.out.println("Anna sukupuoli, N tai M: ");
//        String sukupuoli = lukija.nextLine();
//        if ("N".equals(sukupuoli)) {
//            aiti.setSukupuoli(Sukupuoli.NAINEN);
//        } else if ("M".equals(sukupuoli)) {
//            aiti.setSukupuoli(Sukupuoli.MIES);
//
//        }
//        ihmislista.add(aiti);
//
//        System.out.println("Anna ensimmäinen sukupolvi! Isän nimi: ");
//        nimi = lukija.nextLine();
//        Henkilo isa = new Henkilo(nimi);
//        System.out.println("Anna sukupuoli, N tai M: ");
//        sukupuoli = lukija.nextLine();
//        if ("N".equals(sukupuoli)) {
//            isa.setSukupuoli(Sukupuoli.NAINEN);
//
//        } else if ("M".equals(sukupuoli)) {
//            isa.setSukupuoli(Sukupuoli.MIES);
//        }
//        ihmislista.add(isa);
        //HUOM!!! Jälkeläisten lisäämistä while-loopilla kokeiltu, ei onnistunut ainakaan parissa tunnissa (prkl)! Unohda se vaihtoehto!
        //Jotain voisi toki pilkkoa metodeiksi ja lyhentää koodia
//        System.out.println("Anna toinen sukupolvi!");
//
//        System.out.println("Anna toinen sukupolvi! Lapsen nimi: ");
//        nimi = lukija.nextLine();
//        Henkilo lapsi1 = new Henkilo(nimi);
//        System.out.println("Anna sukupuoli, N tai M: ");
//        sukupuoli = lukija.nextLine();
//        if ("N".equals(sukupuoli)) {
//            lapsi1.setSukupuoli(Sukupuoli.NAINEN);
//
//        } else if ("M".equals(sukupuoli)) {
//            lapsi1.setSukupuoli(Sukupuoli.MIES);
//        }
//        ihmislista.add(lapsi1);

//        System.out.println("Anna toinen sukupolvi! Lapsen nimi: ");
//        nimi = lukija.nextLine();
//        Henkilo lapsi2 = new Henkilo(nimi);
//        System.out.println("Anna sukupuoli, N tai M: ");
//        sukupuoli = lukija.nextLine();
//        if ("N".equals(sukupuoli)) {
//            lapsi2.setSukupuoli(Sukupuoli.NAINEN);
//
//        } else if ("M".equals(sukupuoli)) {
//            lapsi2.setSukupuoli(Sukupuoli.MIES);
//        }
//        ihmislista.add(lapsi2);

//        System.out.println("Anna toinen sukupolvi! Lapsen nimi: ");
//        nimi = lukija.nextLine();
//        Henkilo lapsi3 = new Henkilo(nimi);
//        System.out.println("Anna sukupuoli, N tai M: ");
//        sukupuoli = lukija.nextLine();
//        if ("N".equals(sukupuoli)) {
//            lapsi3.setSukupuoli(Sukupuoli.NAINEN);
//
//        } else if ("M".equals(sukupuoli)) {
//            lapsi3.setSukupuoli(Sukupuoli.MIES);
//        }
//        ihmislista.add(lapsi3);

   //     for (Henkilo ihminen : ihmislista) {
   //         ihminen.toString();
   //     }
        
        //Piirustuslogiikka-luokka siis saa listan henkilöitä (nimi ja sukupuoli), joiden perusteella piirtää tässä vaiheessa ympyrän tai neliön
        
        Piirustuslogiikka logic = new Piirustuslogiikka(ihmislista);
        ArrayList<Kuvio> kuviot = logic.piirraSukupuolet();     //"Muuttaa" henkilöt kuvioiksi
        ArrayList<Kuvio> viivat = logic.piirraPuolisoilleViivat();
        
        kuviot.addAll(viivat);      //yhdistää aiemmat kaksi listaa
        
        PiirtoKayttoliittyma kayttis = new PiirtoKayttoliittyma(kuviot);        //Piirtää ne kuviot
        SwingUtilities.invokeLater(kayttis);
    }

}
