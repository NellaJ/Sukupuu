package piirustus;

import java.util.ArrayList;
import sukupuu.Henkilo;
import sukupuu.Sukupuoli;

public class Piirustuslogiikka {

    //TODO. IHAN VAIHEESSA!!! 
    //Piirretäänkö kumpi kuvio, minne ja värillä vai ilman?
    //Saa ainakin listan henkilöitä

    private ArrayList<Henkilo> ihmiset;

    public Piirustuslogiikka(ArrayList<Henkilo> ihmiset) {
        this.ihmiset = ihmiset;
    }

    //Muuttaa henkilön neliöksi tai ympyräksi sukupuolen perusteella, koordinaatit lasketaan muualla.
    //Palauttaa listan kuvioita
    public ArrayList<Kuvio> piirraSukupuolet() {
        ArrayList<Kuvio> kuviolista = new ArrayList<Kuvio>();

        for (Henkilo henkilo : ihmiset) {
            if (henkilo.getSukupuoli() == Sukupuoli.MIES) {
                kuviolista.add(new Nelio(laskeX(henkilo), laskeY(henkilo), laskeKorkeus()));
            } else if (henkilo.getSukupuoli() == Sukupuoli.NAINEN) {
                kuviolista.add(new Ympyra(laskeX(henkilo), laskeY(henkilo), laskeKorkeus()));
            } //else -> jos sukupuoli on "MUU"          TODO!
        }

        return kuviolista;
    }
    
    //Laskee x-koordinaatin, vaiheessa!
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
    public int laskeY(Henkilo henkilo) {
        int y = 0;
        
        if (ihmiset.get(0) == henkilo || ihmiset.get(1) == henkilo) {
            y = 50;
        } else {
            y = 200;
        }
        
        return y;
    }
    
    //Laskee sivun pituuden/halkaisijan, voisi olla vakio
    public int laskeKorkeus() {
        int numero = 50;
        
        return(numero);
    }

}
