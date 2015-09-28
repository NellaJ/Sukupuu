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
    private ArrayList<Kuvio> kuviolista;

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
    public ArrayList<Kuvio> piirraKuviot() {
        this.kuviolista = new ArrayList<Kuvio>();
        henkiloKuviot = new HashMap<>();        //Talteen henkilöön liittyvä kuvio

        ArrayList<Henkilo> ekaPolvi = new ArrayList<Henkilo>();
        ArrayList<Henkilo> tokaPolvi = new ArrayList<Henkilo>();
        ArrayList<Henkilo> kolmasPolvi = new ArrayList<Henkilo>();
        ArrayList<Henkilo> neljasPolvi = new ArrayList<Henkilo>();

        for (Henkilo henkilo : ihmiset) {
            if (henkilo.getSukupolvi() == 1) {
                ekaPolvi.add(henkilo);
            }
            if (henkilo.getSukupolvi() == 2) {
                tokaPolvi.add(henkilo);
            }
            if (henkilo.getSukupolvi() == 3) {
                kolmasPolvi.add(henkilo);
            }
            if (henkilo.getSukupolvi() == 4) {
                neljasPolvi.add(henkilo);
            }
        }
        muutaSukupuolet(ekaPolvi);
        muutaSukupuolet(tokaPolvi);
        muutaSukupuolet(kolmasPolvi);
        muutaSukupuolet(neljasPolvi);

        piirraPuolisoilleViivat();
        piirraViivatLapsiin();

        return kuviolista;
    }

    //Sekava! X-koordinaatit pitäisi laskea paremmin
    public void muutaSukupuolet(ArrayList<Henkilo> polviLista) {

        for (Henkilo henkilo : polviLista) {
            int i = polviLista.indexOf(henkilo);
            if (henkilo.getSukupuoli() == Sukupuoli.MIES) {
                //   kuviolista.add(new Nelio(laskeX(i), laskeY(henkilo), laskeKorkeus()));
                henkiloKuviot.put(henkilo.getNimi(), (new Nelio(laskeX(i), laskeY(henkilo), laskeKorkeus())));
                kuviolista.add(henkiloKuviot.get(henkilo.getNimi()));
            } else if (henkilo.getSukupuoli() == Sukupuoli.NAINEN) {
                // kuviolista.add(new Ympyra(laskeX(i), laskeY(henkilo), laskeKorkeus()));
                henkiloKuviot.put(henkilo.getNimi(), (new Ympyra(laskeX(i), laskeY(henkilo), laskeKorkeus())));
                kuviolista.add(henkiloKuviot.get(henkilo.getNimi()));
            } //else -> jos sukupuoli on "MUU"          TODO!
        }
    }

    //Laskee x-koordinaatin ympyrälle/neliölle, vaiheessa! 
    /**
     *
     * @param henkilo
     * @return
     */
    public int laskeX(int indeksi) {
        int x = 100 + (indeksi * 200);

        return x;
    }

    //Laskee y-koordinaatin ympyrälle/neliölle, vaiheessa!
    /**
     *
     * @param henkilo
     * @return
     */
    public int laskeY(Henkilo henkilo) {
        int y = 0;

        if (henkilo.getSukupolvi() == 1) {
            y = 200;
        }
        if (henkilo.getSukupolvi() == 2) {
            y = 400;
        }
        if (henkilo.getSukupolvi() == 3) {
            y = 600;
        }
        if (henkilo.getSukupolvi() == 4) {
            y = 800;
        }

        return y;
    }

    //Laskee sivun pituuden/halkaisijan, voisi olla vakio
    /**
     *
     * @return
     */
    public int laskeKorkeus() {
        int numero = 60;

        return (numero);
    }

    //Viiva menee kuvion keskeltä kuvion keskelle nyt. Piirtää viivan puolisoiden välille
    public ArrayList<Kuvio> piirraPuolisoilleViivat() {

        ArrayList<Kuvio> viivat = new ArrayList<>();
        for (Henkilo henkilo : ihmiset) {
            if (henkilo.getPuoliso() != null) {
                viivat.add(new Viiva(haeXKoordinaatti(henkilo), haeYKoordinaatti(henkilo), haeXKoordinaatti(henkilo.getPuoliso()), haeYKoordinaatti(henkilo.getPuoliso())));
            }
        }
        if (viivat.size() > 0) {
        kuviolista.addAll(viivat);
        }
        return kuviolista;
    }

    //Hakee HashMapista henkilöön liittyvän neliön/ympyrän x-koordinaatin
    public int haeXKoordinaatti(Henkilo henkilo) {
        int x = 0;

        x = henkiloKuviot.get(henkilo.getNimi()).getX();
        x = x + (laskeKorkeus() / 2);
        return x;
    }

    //Hakee HashMapista henkilöön liittyvän neliön/ympyrän y-koordinaatin
    public int haeYKoordinaatti(Henkilo henkilo) {
        int y = 0;

        y = henkiloKuviot.get(henkilo.getNimi()).getY();
        y = y + (laskeKorkeus() / 2);
        return y;
    }
//Yhden lapsen tapaus pitää testata!

    public ArrayList<Kuvio> piirraViivatLapsiin() {
        ArrayList<Kuvio> lapsiviivat = new ArrayList<>();
        int a = 0;
        for (Henkilo henkilo : ihmiset) {
            if (henkilo.getLapset() != null && henkilo.getLapset().size() > 0) {
                if (henkilo.getLapset().size() == 1) {
                    lapsiviivat.add(new Viiva(haeXKoordinaatti(henkilo), haeYKoordinaatti(henkilo), haeXKoordinaatti(henkilo.getLapset().get(0)), haeYKoordinaatti(henkilo.getLapset().get(0))));
                } else {
                    System.out.println("Kierros: " + a);
                    lapsiviivat.add(ekaLapsiViiva(henkilo));
                    lapsiviivat.add(tokaLapsiViiva(henkilo));
                     lapsiviivat.addAll(kolmasLapsiviiva(henkilo));
                }
            }
            a++;
        }
        if (lapsiviivat.size() > 0 ) {
        kuviolista.addAll(lapsiviivat);
        }
        return kuviolista;
    }

    public Kuvio ekaLapsiViiva(Henkilo henkilo) {

        int x1 = (haeXKoordinaatti(henkilo) + haeXKoordinaatti(henkilo.getPuoliso())) / 2;
        int x2 = (haeXKoordinaatti(henkilo) + haeXKoordinaatti(henkilo.getPuoliso())) / 2;
        int y1 = haeYKoordinaatti(henkilo);
        int y2 = haeYKoordinaatti(henkilo) + 100;   //sukupolvien välillä eroa 200, viiva piirretään sukupolvien puoleen väliin
        Viiva viiva = new Viiva(x1, y1, x2, y2);

        return viiva;
    }

    public Kuvio tokaLapsiViiva(Henkilo henkilo) {
        int pieninX = 1000;
        int suurinX = 0;

        for (Henkilo lapsi : henkilo.getLapset()) {
            if (haeXKoordinaatti(lapsi) <= pieninX) {
                pieninX = haeXKoordinaatti(lapsi);
            }
            if (haeXKoordinaatti(lapsi) >= suurinX) {
                suurinX = haeXKoordinaatti(lapsi);
            }
        }
        
        int y = haeYKoordinaatti(henkilo) + 100;

        Viiva viiva = new Viiva(pieninX, y, suurinX, y);

        return viiva;
    }

    public ArrayList<Kuvio> kolmasLapsiviiva(Henkilo henkilo) {
        ArrayList<Kuvio> viivat = new ArrayList<>();
        int y1 = haeYKoordinaatti(henkilo) + 100;
        int y2 = haeYKoordinaatti(henkilo) + 170;
        for (Henkilo lapsi : henkilo.getLapset()) {
            
            viivat.add(new Viiva(haeXKoordinaatti(lapsi), y1, haeXKoordinaatti(lapsi), y2));
        }

        return viivat;
    }
}
