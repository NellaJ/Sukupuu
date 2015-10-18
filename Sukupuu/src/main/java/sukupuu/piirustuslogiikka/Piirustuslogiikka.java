package sukupuu.piirustuslogiikka;

import java.util.ArrayList;
import java.util.HashMap;
import sukupuu.henkilo.Henkilo;
import sukupuu.henkilo.Sukupuoli;

/**
 * Luokka sisältää logiikan jonka mukaan eri kuviot piirretään: mikä kuvio,
 * sille koordinaatit ja värillä vai ilman. Luokka saa syötteenä listan
 * henkilöitä: ArrayList ihmiset. Lisäksi luodaan ArrayList kuviolista, jonne
 * luodut kuviot talletetaan sekä HashMap henkilonKuvio, johon tallentuu sekä
 * Henkilön nimi että henkilöön liittyvä kuvio
 */
public class Piirustuslogiikka {

    private ArrayList<Henkilo> ihmiset;
    private HashMap<String, Kuvio> henkilonKuvio;
    private ArrayList<Kuvio> kuviolista;
    private ArrayList<Koordinaatti> koordinaatit;
    private HashMap<Henkilo, Henkilo> puolisot;

    /**
     * Konstruktori asettaa parametrina saadun listan henkilöistä
     * ihmiset-listaan. Luo kuviolistan ja henkilonKuvio-HashMapin. Luo listan
     * koordinaateista ja kutsuu metodia, joka luo koordinaatit ja tallettaa
     * koordinaatit-listaan. Luo HashMapin puolisoille.
     *
     * @param ihmiset
     */
    public Piirustuslogiikka(ArrayList<Henkilo> ihmiset) {
        this.ihmiset = ihmiset;
        this.kuviolista = new ArrayList<Kuvio>();
        this.henkilonKuvio = new HashMap<>();        //Talteen henkilöön liittyvä kuvio
        this.koordinaatit = new ArrayList<Koordinaatti>();
        luoKoordinaatit();
        this.puolisot = new HashMap<Henkilo, Henkilo>();
    }

    /**
     * Metodi kutsuu neljää muuta metodia, jotka luovat kaikki tarvittavat
     * kuviot.
     *
     * @return kuviolista lista kuvioita
     */
    public ArrayList<Kuvio> luoKuviot() {

        luoPuolisoLista();
        henkilotKuvioiksi();
        luoPuolisoViivat();
        luoViivatLapsiin();

        return kuviolista;
    }

    /**
     * Luo listan puoliso-henkilöitä. Käy läpi ihmiset-listan. Jos löytää
     * henkilön, jolla on puoliso, lisää henkilön puolisot-HashMapiin avaimena
     * ja tallettaa henkilön puolison arvoksi. Tarkistaa myös, onko henkilö jo
     * puoliso-HashMapissa avaimena tai arvona ja ei tällöin lisää henkilöä enää
     * sinne.
     */
    public void luoPuolisoLista() {
        for (Henkilo henkilo : this.ihmiset) {
            if (henkilo.getPuoliso() != null && puolisot.containsKey(henkilo) == false && puolisot.containsValue(henkilo) == false) {
                this.puolisot.put(henkilo, haePuoliso(henkilo));
            }
        }
    }

    /**
     * Kutsuu ensin metodia. Tämän jälkeen käy läpi ihmiset-listan. Jos henkilöä
     * ei ole henkilonKuvio-HashMapissa, hakee henkilölle koordinaatin metodia
     * kutsumalla (parametrina henkilo), asettaa koordinaatin tilan falseksi ja
     * luo henkilölle kuvion kutsumalla metodia (parametreina henkilo sekä
     * koordinaatin x ja y). Koska perheille luodaan kuviot ensin, varmistetaan
     * se että sekä puolisoiden että sisarusten kuviot tulevat vierekkäin.
     *
     */
    public void henkilotKuvioiksi() {
        perheetKuvioiksi();

        for (Henkilo henkilo : ihmiset) {
            if (henkilonKuvio.containsKey(henkilo.getNimi()) == false) {
                Koordinaatti k = haeKoordinaatti(henkilo);
                k.setVapaana(false);
                luoKuvio(henkilo, k.getX(), k.getY());
            }
        }
    }

    /**
     * Käy läpi puolisot-HashMapin. Hakee henkilölle koordinaatin metodia
     * kutsumalla, asettaa koordinaatin tilan falseksi ja luo henkilölle kuvion
     * metodia kutsumalla. Seuraavaksi hakee koordinaatin henkilön puolisolle,
     * niin että ottaa henkilön koordinaatin indeksin koordinaatti-listasta ja
     * hakee sitä seuraavalla indeksillä sieltä koordinaatin. Puolison
     * koordinaatti asetetaan falseksi ja luodaan kuvio. Vierekkäisillä listan
     * indekseillä siis varmistetaan, että puolisoiden kuviot tulevat
     * vierekkäin. Lisäksi vielä kutsutaan metodia lasten kuvioiden luomiseksi.
     */
    public void perheetKuvioiksi() {
        for (Henkilo henkilo : puolisot.keySet()) {

            Koordinaatti k = haeKoordinaatti(henkilo);
            k.setVapaana(false);
            luoKuvio(henkilo, k.getX(), k.getY());

            int indeksi = this.koordinaatit.indexOf(k);
            Koordinaatti k2 = this.koordinaatit.get(indeksi + 1);
            if (k2.isVapaana() == false) {
                k2 = this.koordinaatit.get(indeksi - 1);
            }
            k2.setVapaana(false);
            luoKuvio(puolisot.get(henkilo), k2.getX(), k2.getY());

            kuviotLapsille(henkilo);
        }
    }

    /**
     * Hakee henkilölle koordinaatin. Henkilön sukupolvi määrittää
     * y-koordinaatin. Koordinaatti-lista käydään läpi ja palautetaan
     * ensimmäinen koordinaatti, jonka y-koordinaatti on henkilön sukupolvea
     * vastaava ja jonka tila on true (eli vapaana). Jos tällaista koordinaattia
     * ei löydy, palauttaa koordinaatin 0,0. Hakee aina parillisen koordinaatin,
     * tällöin mahdolliselle puolisolle jää kuvion viereen tilaa (puolisoille
     * tulee aina pariton koordinaatti)
     *
     * @param henkilo
     * @return Koordinaatti
     */
    public Koordinaatti haeKoordinaatti(Henkilo henkilo) {
        int y = henkilo.getSukupolvi() * 200;
        int a = 0;
        while (a <= this.koordinaatit.size() - 1) {
            Koordinaatti k = this.koordinaatit.get(a);
            if (k.getY() == y && k.isVapaana() == true) {
                return k;
            }
            a = a + 2;
        }
        return new Koordinaatti(0, 0, true);
    }

    /**
     * Luo uuden kuvion kutsumalla metodia. Jos sukupuoli on mies, kutsutaan
     * teeNelio ja jos nainen, teeYmpyra. Lisää luodun kuvion
     * henkilonKuvio-HashMapiin henkilön nimen kanssa sekä kuviolistaan. (MUU ja
     * vinoneliön luominen puuttuu)
     *
     * @param Henkilo kuvioitava
     * @param int xKoordinaatti
     * @param int YKoordinaatti
     */
    public void luoKuvio(Henkilo kuvioitava, int xKoordinaatti, int YKoordinaatti) {

        if (kuvioitava.getSukupuoli() == Sukupuoli.MIES) {
            henkilonKuvio.put(kuvioitava.getNimi(), teeNelio(kuvioitava, xKoordinaatti, YKoordinaatti));
            kuviolista.add(henkilonKuvio.get(kuvioitava.getNimi()));
        } else if (kuvioitava.getSukupuoli() == Sukupuoli.NAINEN) {
            henkilonKuvio.put(kuvioitava.getNimi(), teeYmpyra(kuvioitava, xKoordinaatti, YKoordinaatti));
            kuviolista.add(henkilonKuvio.get(kuvioitava.getNimi()));
        } //else -> MUU = Vinoneliö. TODO
    }

    /**
     * Hakee henkilön puolison ihmiset-listasta ja palauttaa sen. Miksi näin?
     * Henkilon getPuoliso-metodi ei palauta oikeaa henkilo-oliota Jos puolisoa
     * ei löydy, palauttaa null.
     *
     * @param Henkilo puoliso
     * @return Henkilo ihminen Parametri-puolison puoliso.
     */
    public Henkilo haePuoliso(Henkilo puoliso) {
        for (Henkilo ihminen : ihmiset) {
            if (puoliso.getPuoliso().getNimi().equals(ihminen.getNimi())) {
                return ihminen;
            }
        }
        return null;
    }

    /**
     * Luo kuviot henkilon jälkeläisille. Käy läpi vanhemman getLapset-listan ja
     * ihmiset-listan. Jos ihmiset-listan henkilo vastaa parametrina olevan
     * vanhemman lasta, eikä ole puolisot-HashMapissa avaimena eikä arvona,
     * haetaan henkilolle koordinaatti metodia kutsumalla. Koordinaatti
     * asetetaan falseksi ja luodaan kuvio metodia kutsumalla.
     * Puolisot-HashMap-tarkistetaan siksi, ettei henkilon kuviota piirrettäisi
     * kahteen kertaan (puolisona ja lapsena)
     *
     * @param vanhempi
     */
    public void kuviotLapsille(Henkilo vanhempi) {
        for (Henkilo lapsi : vanhempi.getLapset()) {
            for (Henkilo h : ihmiset) {
                if (lapsi.getNimi().equals(h.getNimi()) && puolisot.containsKey(h) == false && puolisot.containsValue(h) == false) {
                    Koordinaatti k = haeKoordinaatti(h);
                    k.setVapaana(false);
                    luoKuvio(h, k.getX(), k.getY());
                }
            }
        }
    }

    /**
     * Metodi luo uuden neliön, parametreista saadaan x ja y, sivunpituus
     * saadaan metodia kutsumalla. Kutsuu metodia värin asettamiseksi,
     * parametreina henkilo ja luotu nelio.
     *
     * @param henkilo
     * @param x
     * @param y
     * @return luotu neliö
     */
    public Nelio teeNelio(Henkilo henkilo, int x, int y) {
        Nelio nelio = new Nelio(x, y, laskeKorkeus());
        variKuviolle(henkilo, nelio);
        return nelio;
    }

    /**
     * Metodi luo uuden ympyrän, parametreista x j y, halkaisija metodia
     * kutsumalla. Kutsuu metodia värin asettamiseksi
     *
     * @param henkilo
     * @param x
     * @param y
     * @return luotu ympyrä
     */
    public Ympyra teeYmpyra(Henkilo henkilo, int x, int y) {
        Ympyra ympyra = new Ympyra(x, y, laskeKorkeus());
        variKuviolle(henkilo, ympyra);
        return ympyra;
    }

    /**
     * Palauttaa neliön sivun pituuden / ympyrän halkaisijan
     *
     * @return korkeus
     */
    public int laskeKorkeus() {
        int korkeus = 60;

        return korkeus;
    }

    /**
     * Luo listan Viiva-kuvioita, jonka toinen pää alkaa toisesta puolisosta ja
     * loppuu toiseen (mutta niin että viiva alkaa kuvion reunasta). Käy siis
     * läpi koko henkilö-listan. Luodut viivat lisätään listana kuviolistaan
     * metodia kutsumalla. Laskee koordinaatit muiden metodien avulla.
     */
    public void luoPuolisoViivat() {
        ArrayList<Kuvio> viivat = new ArrayList<>();
        for (Henkilo h : ihmiset) {
            if (h.getPuoliso() != null) {
                if (henkilonKuvio.get(h.getNimi()).getX() < henkilonKuvio.get(h.getPuoliso().getNimi()).getX()) {
                    viivat.add(new Viiva(xViivalle(h) + (laskeKorkeus() / 2), yViivalle(h), xViivalle(h.getPuoliso()) - laskeKorkeus() / 2, yViivalle(h.getPuoliso())));
                } else {
                    viivat.add(new Viiva(xViivalle(h) - (laskeKorkeus() / 2), yViivalle(h), xViivalle(h.getPuoliso()) + laskeKorkeus() / 2, yViivalle(h.getPuoliso())));
                }
            }
        }
        if (viivat.size() > 0) {
            lisaaKuvioListaan(viivat);
        }
    }

    /**
     * Hakee HashMapista henkilonKuvio henkilön nimen perusteella kuvion ja
     * kuvion x-koordinaatin sekä laskee siitä uuden x-koordinaatin
     *
     * @param henkilo
     * @return x-koordinaatti
     */
    public int xViivalle(Henkilo henkilo) {
        int x = 0;
        x = henkilonKuvio.get(henkilo.getNimi()).getX();
        x = x + (laskeKorkeus() / 2);
        return x;
    }

    /**
     * Hakee HashMapista henkilonKuvio henkilön nimen perusteella kuvion ja
     * kuvion y-koordinaatin sekä laskee siitä uuden y-koordinaatin
     *
     * @param henkilo
     * @return y-koordinaatti
     */
    public int yViivalle(Henkilo henkilo) {
        int y = 0;
        y = henkilonKuvio.get(henkilo.getNimi()).getY();
        y = y + (laskeKorkeus() / 2);
        return y;
    }

    /**
     * Logiikka, joka liittyy lapsien ja vanhempien välisiin viivoihin. Luo
     * uuden listan lapsiviivat, kutsuu kolmea muuta metodia ja lisää uudet
     * viivat listana kuviolistaan metodia kutsumalla. Yhdelle lapselle viiva
     * luodaan hiukan eri tavalla.
     */
    public void luoViivatLapsiin() {
        ArrayList<Kuvio> lapsiviivat = new ArrayList<>();

        for (Henkilo henkilo : ihmiset) {
            if (henkilo.getLapset() != null && henkilo.getLapset().size() > 0) {
                if (henkilo.getLapset().size() == 1) {
                    Henkilo lapsi = henkilo.getLapset().get(0);
                    lapsiviivat.add(ekaLapsiViiva(henkilo));
                    lapsiviivat.add(new Viiva(((xViivalle(henkilo) + xViivalle(henkilo.getPuoliso())) / 2), (yViivalle(henkilo) + 100), xViivalle(lapsi), yViivalle(lapsi) - (laskeKorkeus() / 2)));
                } else {
                    lapsiviivat.add(ekaLapsiViiva(henkilo));
                    lapsiviivat.add(tokaLapsiViiva(henkilo));
                    lapsiviivat.addAll(kolmasLapsiviiva(henkilo));
                }
            }
        }
        if (lapsiviivat.size() > 0) {
            lisaaKuvioListaan(lapsiviivat);
        }
    }

    /**
     * Luo uuden viivan puolisoiden viivan keskeltä alaspäin. Laskee
     * koordinaatit vanhempien kuvioiden koordinaattien perusteella
     *
     * @param henkilo
     * @return luotu viiva
     */
    public Viiva ekaLapsiViiva(Henkilo henkilo) {

        int x1 = (xViivalle(henkilo) + xViivalle(henkilo.getPuoliso())) / 2;
        int x2 = (xViivalle(henkilo) + xViivalle(henkilo.getPuoliso())) / 2;
        int y1 = yViivalle(henkilo);
        int y2 = yViivalle(henkilo) + 100;   //sukupolvien välillä eroa 200, viiva piirretään sukupolvien puoleen väliin

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
    public Viiva tokaLapsiViiva(Henkilo henkilo) {
        int pieninX = 1000;
        int suurinX = 0;

        for (Henkilo lapsi : henkilo.getLapset()) {
            if (xViivalle(lapsi) <= pieninX) {
                pieninX = xViivalle(lapsi);
            }
            if (xViivalle(lapsi) >= suurinX) {
                suurinX = xViivalle(lapsi);
            }
        }
        int y = yViivalle(henkilo) + 100;

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
    public ArrayList<Viiva> kolmasLapsiviiva(Henkilo henkilo) {
        ArrayList<Viiva> viivat = new ArrayList<>();
        int y1 = yViivalle(henkilo) + 100;
        int y2 = yViivalle(henkilo) + 170;

        for (Henkilo lapsi : henkilo.getLapset()) {
            viivat.add(new Viiva(xViivalle(lapsi), y1, xViivalle(lapsi), y2));
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

    /**
     * Jos Henkilön onkoSairas-metodi palauttaa true, määrittää kuvion
     * värilliseksi
     *
     * @param henkilo
     * @param kuvio
     */
    public void variKuviolle(Henkilo henkilo, Kuvio kuvio) {
        if (henkilo.onkoSairas() == true) {
            kuvio.setVari(true);
        }
    }

    /**
     * Luo HashMapin, jossa avaimena String henkilön nimi ja arvona henkilöön
     * liittyvä kuvio. Käy läpi koko henkilonKuvio-HashMapin ja lisää kaikki
     * uuteen HashMapiin.
     *
     * @return HashMap tekstilista
     */
    public HashMap<Kuvio, String> teeStringLista() {
        HashMap<Kuvio, String> tekstilista = new HashMap<Kuvio, String>();

        for (String nimi : henkilonKuvio.keySet()) {
            tekstilista.put(henkilonKuvio.get(nimi), nimi);
        }
        return tekstilista;
    }

    /**
     * Luo listan Koordinaatti-luokan olioita. Luotavat x-koordinaatit on
     * ennestään määritelty, y-koordinaattien määrä tulee ihmiset-listan
     * henkilöiden suurimman sukupolven arvosta. Kaikkien koordinaattien tila on
     * alussa true, eli vapaana.
     *
     */
    public void luoKoordinaatit() {
        int sukupolvienMaara = 0;
        for (Henkilo henkilo : this.ihmiset) {
            if (henkilo.getSukupolvi() > sukupolvienMaara) {
                sukupolvienMaara = henkilo.getSukupolvi();
            }
        }
        int a = 1;
        while (a <= sukupolvienMaara) {
            koordinaatit.add(new Koordinaatti(100, (a * 200), true));
            koordinaatit.add(new Koordinaatti(200, (a * 200), true));
            koordinaatit.add(new Koordinaatti(300, (a * 200), true));
            koordinaatit.add(new Koordinaatti(400, (a * 200), true));
            koordinaatit.add(new Koordinaatti(500, (a * 200), true));
            koordinaatit.add(new Koordinaatti(600, (a * 200), true));
            koordinaatit.add(new Koordinaatti(700, (a * 200), true));
            koordinaatit.add(new Koordinaatti(800, (a * 200), true));
            koordinaatit.add(new Koordinaatti(900, (a * 200), true));
            koordinaatit.add(new Koordinaatti(1000, (a * 200), true));

            a++;
        }
    }

    public ArrayList<Koordinaatti> getKoordinaatit() {
        return koordinaatit;
    }
}
