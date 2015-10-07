/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuu.main;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import sukupuu.GraafinenKayttis.Graafinen;
import sukupuu.piirustus.Kuvio;
import sukupuu.piirustus.PiirtoKayttoliittyma;
import sukupuu.piirustus.Piirustuslogiikka;
import sukupuu.sukupuu.Henkilo;

/**
 *
 * @author Hourula
 */
public class Ohjelmalogiikka {

    private ArrayList<Henkilo> ihmislista;

    public Ohjelmalogiikka(ArrayList<Henkilo> lista) {
        this.ihmislista = lista;
        start();
    }

//    public void lisaaListaan(Henkilo henkilo) {
//        ihmislista.add(henkilo);
//    }
    private void start() {
//        System.out.println("Ohjelmalogiikka pyörii!!!");
//        for (Henkilo henkilo : ihmislista) {
//            System.out.println(henkilo.toString());
//            System.out.println(henkilo.getMutaatiot().get(0));
//            System.out.println("Sukupolvi: " + henkilo.getSukupolvi());
//            System.out.println("Puoliso: " + henkilo.getPuoliso().getNimi());
//            for (Henkilo lapsi : henkilo.getLapset()) {
//                System.out.println("Lapsi: " + lapsi.getNimi());
//            }
//        }

        Piirustuslogiikka logic = new Piirustuslogiikka(ihmislista);
        ArrayList<Kuvio> kuviot = logic.piirraKuviot();     //"Muuttaa" henkilöt kuvioiksi

        PiirtoKayttoliittyma kayttis = new PiirtoKayttoliittyma(kuviot);        //Piirtää ne kuviot
        SwingUtilities.invokeLater(kayttis);
    }
}
