package piirustus;

import java.util.ArrayList;
import java.util.HashMap;
import sukupuu.Henkilo;
import sukupuu.Sukupuoli;

/**
 * Luokka sisältää logiikan jonka mukaan eri kuviot piirretään Luokka saa
 * syötteenä listan henkilöitä
 */
public class Piirustuslogiikka {

    //TODO. IHAN VAIHEESSA!!! 
    //Piirretäänkö kumpi kuvio, minne ja värillä vai ilman?
    //Saa ainakin listan henkilöitä
    private ArrayList<Henkilo> ihmiset;
    private HashMap<String, Kuvio> henkiloKuviot;       

    public Piirustuslogiikka(ArrayList<Henkilo> ihmiset) {
        this.ihmiset = ihmiset;

    }

    //Muuttaa henkilön neliöksi tai ympyräksi sukupuolen perusteella, koordinaatit lasketaan muualla.
    //Palauttaa listan kuvioita
    /**
     * Metodi saa Piirustuslogiikka-luokan listan henkilöitä ja "muuttaa" ne
     * henkilöiden sukupuolen mukaan kuvioiksi jotka tallentaa uuteen listaan
     * jonka on luonut
     *
     * @return lista kuvioita
     */
    public ArrayList<Kuvio> piirraSukupuolet() {
        ArrayList<Kuvio> kuviolista = new ArrayList<Kuvio>();
        henkiloKuviot = new HashMap<>();        //Talteen henkilöön liittyvä kuvio

        for (Henkilo henkilo : ihmiset) {
            if (henkilo.getSukupuoli() == Sukupuoli.MIES) {
                kuviolista.add(new Nelio(laskeX(henkilo), laskeY(henkilo), laskeKorkeus()));
                henkiloKuviot.put(henkilo.getNimi(), (new Nelio(laskeX(henkilo), laskeY(henkilo), laskeKorkeus())));
            } else if (henkilo.getSukupuoli() == Sukupuoli.NAINEN) {
                kuviolista.add(new Ympyra(laskeX(henkilo), laskeY(henkilo), laskeKorkeus()));
                henkiloKuviot.put(henkilo.getNimi(), (new Nelio(laskeX(henkilo), laskeY(henkilo), laskeKorkeus())));
            } //else -> jos sukupuoli on "MUU"          TODO!
        }

        return kuviolista;
    }

    //Laskee x-koordinaatin, vaiheessa! 
    /**
     *
     * @param henkilo
     * @return
     */
    public int laskeX(Henkilo henkilo) {
        int x = 0;

        if (ihmiset.get(0) == henkilo) {
            x = 50;
        }
        if (ihmiset.get(1) == henkilo) {
            x = 200;
        }
        if (ihmiset.get(2) == henkilo) {
            x = 20;
        }
        if (ihmiset.get(3) == henkilo) {
            x = 100;
        }
        if (ihmiset.get(4) == henkilo) {
            x = 220;
        }

        return x;
    }

    //Laskee y-koordinaatin, vaiheessa!
    /**
     *
     * @param henkilo
     * @return
     */
    public int laskeY(Henkilo henkilo) {
        int y = 0;

        if ("I".equals(henkilo.getSukupolvi())) {
            y = 50;
        } else if ("II".equals(henkilo.getSukupolvi())) {
            y = 200;
        }

        return y;
    }

    //Laskee sivun pituuden/halkaisijan, voisi olla vakio
    /**
     *
     * @return
     */
    public int laskeKorkeus() {
        int numero = 50;

        return (numero);
    }
    //Viiva menee kuvion keskeltä kuvion keskelle nyt
    public ArrayList<Kuvio> piirraPuolisoilleViivat() {

        ArrayList<Kuvio> viivat = new ArrayList<>();
        for (Henkilo henkilo : ihmiset) {
            if (henkilo.getPuoliso() != null) {
                viivat.add(new Viiva(haeXKoordinaatti(henkilo), haeYKoordinaatti(henkilo), haeXKoordinaatti(henkilo.getPuoliso()), haeYKoordinaatti(henkilo.getPuoliso())));
            }
        }
        return viivat;
    }
    
    public int haeXKoordinaatti(Henkilo henkilo) {
        int x = 0;
        
        x = henkiloKuviot.get(henkilo.getNimi()).getX();
        x = x + (laskeKorkeus()/2);
        return x;
    }
    
    public int haeYKoordinaatti(Henkilo henkilo) {
        int y = 0;
        
        y = henkiloKuviot.get(henkilo.getNimi()).getY();
        y = y + (laskeKorkeus()/2);
        return y; 
    }
} 
