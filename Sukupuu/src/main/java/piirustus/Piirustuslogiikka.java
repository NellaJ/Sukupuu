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

    //Piirretäänkö kumpi kuvio, minne ja värillä vai ilman?
    private ArrayList<Henkilo> ihmiset;
    private HashMap<String, Kuvio> henkilonKuvio;
    private ArrayList<Kuvio> kuviolista;

    public Piirustuslogiikka(ArrayList<Henkilo> ihmiset) {
        this.ihmiset = ihmiset;
        this.kuviolista = new ArrayList<Kuvio>();
        this.henkilonKuvio = new HashMap<>();        //Talteen henkilöön liittyvä kuvio
    }

    //Muuttaa henkilön neliöksi tai ympyräksi sukupuolen perusteella, koordinaatit lasketaan muualla.
    //Palauttaa listan kuvioita
    /**
     * Metodi saa Piirustuslogiikka-luokan listan henkilöitä ja "muuttaa" ne
     * henkilöiden sukupuolen mukaan kuvioiksi jotka tallentaa uuteen listaan
     *
     * @return lista kuvioita
     */
    public ArrayList<Kuvio> piirraKuviot() {

        keraaSukupolvet();
        luoPuolisoViivat();
        luoViivatLapsiin();

        return kuviolista;
    }

    //Lisää ihmiset sukupolven mukaan listalle ja sukupolven sisältävä ihmislista muutetaan kuvioiksi
    /**
     * Käy listan henkilöitä while-loopissa niin monta kertaa mikä on listan
     * koko. Apumuuttuja a alkaa numerolla 1. Kierroksen alussa tehdään uusi
     * lista. Joka kierroksella for-luuppi käy henkilö-listan läpi ja jos
     * henkilön sukupolvi on sama kuin apumuuttuja, henkilö lisätään listaan.
     * Kun henkilöt on käyty läpi, kutsutaan metodia muutaSukupuolet, joka
     * "muuttaa" henkilöt kuvioiksi Eli joka kierroksella luodaan uusi lista,
     * johon laitetaan kaikki samaan sukupolveen kuuluvat henkilöt.
     */
    public void keraaSukupolvet() {

        int a = 1;
        while (a < ihmiset.size()) {
            ArrayList<Henkilo> sukupolvi = new ArrayList<>();
            for (Henkilo henkilo : ihmiset) {
                if (henkilo.getSukupolvi() == a) {
                    sukupolvi.add(henkilo);
                }
            }
            muutaSukupuolet(sukupolvi);
            a++;
        }
    }

    //X-koordinaatit voisi laskea paremmin. Saa listan jossa koko sukupolvi, käy läpi ihmiset, tekee kuvion ja lisää sen kuviolistaan
    /**
     * Saa listan, jossa on saman sukupolven henkilöt. Lista käydään läpi ja jos
     * henkilö on mies, tehdään metodin avulla uusi henkilö, joka lisätään
     * henkilön nimen kanssa HashMapiin ja luotu kuvio myös listaan. Jos henkilö
     * on nainen, tehdään samoin mutta tuloksena on uusi ympyrä.
     *
     * @param sukupolvi
     */
    public void muutaSukupuolet(ArrayList<Henkilo> sukupolvi) {

        for (Henkilo henkilo : sukupolvi) {
            int i = sukupolvi.indexOf(henkilo);        //Sukupolvi listana, järjestys kuvioille siitä
            if (henkilo.getSukupuoli() == Sukupuoli.MIES) {
                henkilonKuvio.put(henkilo.getNimi(), teeNelio(henkilo, i));
                kuviolista.add(henkilonKuvio.get(henkilo.getNimi()));
            } else if (henkilo.getSukupuoli() == Sukupuoli.NAINEN) {
                henkilonKuvio.put(henkilo.getNimi(), teeYmpyra(henkilo, i));
                kuviolista.add(henkilonKuvio.get(henkilo.getNimi()));
            } //else -> jos sukupuoli on "MUU"          TODO!
        }
    }

    /**
     * Metodi luo uuden neliön. Neliön parametrit saadaan kutsumalla kolmea
     * muuta metodia
     *
     * @param henkilo
     * @param indeksi eli henkilön indeksi sukupolvi-listassa
     * @return luotu neliö
     */
    public Nelio teeNelio(Henkilo henkilo, int indeksi) {
        Nelio nelio = new Nelio(laskeX(indeksi), laskeY(henkilo), laskeKorkeus());
        return nelio;
    }

    /**
     * Metodi luo uuden ympyrän. Ympyrän parametrit saadaan kutsumalla kolmea
     * muuta metodia
     *
     * @param henkilo
     * @param indeksi
     * @return luotu ympyrä
     */
    public Ympyra teeYmpyra(Henkilo henkilo, int indeksi) {
        Ympyra ympyra = new Ympyra(laskeX(indeksi), laskeY(henkilo), laskeKorkeus());
        return ympyra;
    }

    //Laskee x-koordinaatin ympyrälle/neliölle, voisi olla fiksummin
    /**
     * Laskee x-koordinaatin kuviolle
     *
     * @param int indeksi, henkilön indeksi listassa
     * @return x-koordinaatti
     */
    public int laskeX(int indeksi) {
        int x = 100 + (indeksi * 200);

        return x;
    }

    //Laskee y-koordinaatin ympyrälle/neliölle, voisi tehdä fiksummin
    /**
     * Laskee y-koordinaatin kuviolle
     *
     * @param henkilo
     * @return y-koordinaatti
     */
    public int laskeY(Henkilo henkilo) {
        int y = 0;

        y = henkilo.getSukupolvi() * 200;

        return y;
    }

    //Laskee sivun pituuden/halkaisijan, voisi olla vakio
    /**
     * Laskee neliön sivun pituuden tai ympyrän halkaisijan
     *
     * @return numero
     */
    public int laskeKorkeus() {
        int korkeus = 60;

        return korkeus;
    }

    //Viiva menee kuvion keskeltä kuvion keskelle nyt. Piirtää viivan puolisoiden välille
    /**
     * Luo listan Viiva-kuvioita, jonka toinen pää alkaa toisesta puolisosta ja
     * loppuu toiseen. Käy siis läpi koko henkilö-listan. Luodut viivat lisätään
     * listana kuviolistaan
     *
     * @return kuviolista
     */
    public void luoPuolisoViivat() {

        ArrayList<Kuvio> viivat = new ArrayList<>();
        for (Henkilo henkilo : ihmiset) {
            if (henkilo.getPuoliso() != null) {
                if (henkilonKuvio.get(henkilo.getNimi()).getX() < henkilonKuvio.get(henkilo.getPuoliso().getNimi()).getX()) {
                    viivat.add(new Viiva(kuvionXViivanKoordinaatiksi(henkilo) + (laskeKorkeus() / 2), kuvionYViivanKoordinaatiksi(henkilo), kuvionXViivanKoordinaatiksi(henkilo.getPuoliso()) - laskeKorkeus() / 2, kuvionYViivanKoordinaatiksi(henkilo.getPuoliso())));
                } else {
                    viivat.add(new Viiva(kuvionXViivanKoordinaatiksi(henkilo) - (laskeKorkeus() / 2), kuvionYViivanKoordinaatiksi(henkilo), kuvionXViivanKoordinaatiksi(henkilo.getPuoliso()) + laskeKorkeus() / 2, kuvionYViivanKoordinaatiksi(henkilo.getPuoliso())));
                }

            }
        }
        if (viivat.size() > 0) {
            lisaaKuvioListaan(viivat);
        }

    }

    //Hakee HashMapista henkilöön liittyvän neliön/ympyrän x-koordinaatin
    /**
     * Hakee HashMapista henkilonKuvio henkilön nimen perusteella kuvion ja
     * kuvion x-koordinaatin sekä laskee siitä uuden x-koordinaatin
     *
     * @param henkilo
     * @return x-koordinaatti
     */
    public int kuvionXViivanKoordinaatiksi(Henkilo henkilo) {
        int x = 0;

        x = henkilonKuvio.get(henkilo.getNimi()).getX();
        x = x + (laskeKorkeus() / 2);
        return x;
    }

    //Hakee HashMapista henkilöön liittyvän neliön/ympyrän y-koordinaatin
    /**
     * Hakee HashMapista henkilonKuvio henkilön nimen perusteella kuvion ja
     * kuvion y-koordinaatin sekä laskee siitä uuden y-koordinaatin
     *
     * @param henkilo
     * @return y-koordinaatti
     */
    public int kuvionYViivanKoordinaatiksi(Henkilo henkilo) {
        int y = 0;

        y = henkilonKuvio.get(henkilo.getNimi()).getY();
        y = y + (laskeKorkeus() / 2);
        return y;
    }
//Yhden lapsen tapaus pitää testata!

    /**
     * Logiikka, joka liittyy lapsien ja vanhempien välisiin viivoihin. Luo
     * uuden listan lapsiviivat, kutsuu kolmea muuta metodia ja lisää uudet
     * viivat listana kuviolistaan
     *
     * @return kuviolista
     */
    public void luoViivatLapsiin() {
        ArrayList<Kuvio> lapsiviivat = new ArrayList<>();
        int a = 0;
        for (Henkilo henkilo : ihmiset) {
            if (henkilo.getLapset() != null && henkilo.getLapset().size() > 0) {
                if (henkilo.getLapset().size() == 1) {
                    lapsiviivat.add(new Viiva(kuvionXViivanKoordinaatiksi(henkilo), kuvionYViivanKoordinaatiksi(henkilo), kuvionXViivanKoordinaatiksi(henkilo.getLapset().get(0)), kuvionYViivanKoordinaatiksi(henkilo.getLapset().get(0))));
                } else {
                    lapsiviivat.add(ekaLapsiViiva(henkilo));
                    lapsiviivat.add(tokaLapsiViiva(henkilo));
                    lapsiviivat.addAll(kolmasLapsiviiva(henkilo));
                }
            }
            a++;
        }
        if (lapsiviivat.size() > 0) {
            lisaaKuvioListaan(lapsiviivat);
        }
    }

    /**
     * Luo uuden viivan puolisoiden viivasta alaspäin.
     *
     * @param henkilo
     * @return luotu viiva
     */
    public Kuvio ekaLapsiViiva(Henkilo henkilo) {

        int x1 = (kuvionXViivanKoordinaatiksi(henkilo) + kuvionXViivanKoordinaatiksi(henkilo.getPuoliso())) / 2;
        int x2 = (kuvionXViivanKoordinaatiksi(henkilo) + kuvionXViivanKoordinaatiksi(henkilo.getPuoliso())) / 2;
        int y1 = kuvionYViivanKoordinaatiksi(henkilo);
        int y2 = kuvionYViivanKoordinaatiksi(henkilo) + 100;   //sukupolvien välillä eroa 200, viiva piirretään sukupolvien puoleen väliin
        Viiva viiva = new Viiva(x1, y1, x2, y2);

        return viiva;
    }

    /**
     * Luo viivan vaakasuoraan lapsien ja vanhempien väliin. Laskee kuka
     * lapsista on eniten vasemmalla ja kuka eniten oikealla, tästä tiedosta
     * saadaan viivan x-koordinaatit
     *
     * @param henkilo
     * @return luotu viiva
     */
    public Kuvio tokaLapsiViiva(Henkilo henkilo) {
        int pieninX = 1000;
        int suurinX = 0;

        for (Henkilo lapsi : henkilo.getLapset()) {
            if (kuvionXViivanKoordinaatiksi(lapsi) <= pieninX) {
                pieninX = kuvionXViivanKoordinaatiksi(lapsi);
            }
            if (kuvionXViivanKoordinaatiksi(lapsi) >= suurinX) {
                suurinX = kuvionXViivanKoordinaatiksi(lapsi);
            }
        }

        int y = kuvionYViivanKoordinaatiksi(henkilo) + 100;

        Viiva viiva = new Viiva(pieninX, y, suurinX, y);

        return viiva;
    }

    /**
     * Luo listan ja useita uusia viivoja. Nämä viivat menevät vanhempien ja
     * lasten välisestä viivasta lapsiin, eli määrä on sama kuin lapsien määrä.
     * Uudet viivat luodaan käymällä läpi vanhemman lapsi-lista for-luupin
     * avulla.
     *
     * @param henkilo
     * @return viiva-lista
     */
    public ArrayList<Kuvio> kolmasLapsiviiva(Henkilo henkilo) {
        ArrayList<Kuvio> viivat = new ArrayList<>();
        int y1 = kuvionYViivanKoordinaatiksi(henkilo) + 100;
        int y2 = kuvionYViivanKoordinaatiksi(henkilo) + 170;
        for (Henkilo lapsi : henkilo.getLapset()) {

            viivat.add(new Viiva(kuvionXViivanKoordinaatiksi(lapsi), y1, kuvionXViivanKoordinaatiksi(lapsi), y2));
        }

        return viivat;
    }

    public ArrayList<Henkilo> getIhmiset() {
        return ihmiset;
    }

    public HashMap<String, Kuvio> getHenkilonKuvio() {
        return henkilonKuvio;
    }

    public ArrayList<Kuvio> getKuviolista() {
        return kuviolista;
    }

    /**
     * Saa listan kuvioita, jotka lisätään kuviolistaan, joten lopulta kaikki
     * luodut kuviot ovat samassa listassa
     *
     * @param kuviot lista lisätään kuviolistaan
     */
    public void lisaaKuvioListaan(ArrayList<Kuvio> kuviot) {
        kuviolista.addAll(kuviot);
    }

}
