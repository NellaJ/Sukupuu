package sukupuu.henkilo;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokassa useita muuttujia henkilön kuvaamiseen. Henkilön luomiseksi tarvitaan
 * vähintään nimi.
 */
public class Henkilo {

    private String nimi;
    private int ika;
    private boolean sairas;
    private List<String> mutaatiot;
    private int sukupolvi;
    private Sukupuoli sukupuoli;
    private List<Henkilo> lapset;
    private Henkilo puoliso;        //Puoliso tarkoittaa tässä yhteydessä lapsen toista vanhempaa

    /**
     * Konstruktori, jonka parametrina vain nimi. Asettaa muihin muuttujiin
     * oletusarvot.
     *
     * @param nimi
     */
    public Henkilo(String nimi) {
        this.ika = 0;
        this.sairas = false;
        this.mutaatiot = new ArrayList<>();
        this.sukupuoli = Sukupuoli.MUU;
        this.sukupolvi = 0;
        this.nimi = nimi;
        this.lapset = new ArrayList<>();
    }

    /**
     * Konstruktori, jossa useampi parametri. Asettaa lisäksi sukupolven arvoksi
     * 0 ja luo tyhjän listan henkilön lapsille
     *
     * @param nimi
     * @param ika
     * @param sairas
     * @param mutaatiot
     * @param sukupuoli
     */
    public Henkilo(String nimi, int ika, boolean sairas, List<String> mutaatiot, Sukupuoli sukupuoli) {
        this.nimi = nimi;
        this.ika = ika;
        this.sairas = sairas;
        this.mutaatiot = mutaatiot;
        this.sukupuoli = sukupuoli;
        this.sukupolvi = 0;
        this.lapset = new ArrayList<>();
    }

    /**
     * Konstruktorissa luotuun listaan voidaan lisätä henkilön jälkeläiset.
     *
     * @param jalkelainen Käyttäjän syöttämä henkilö
     */
    public void lisaaLapsi(Henkilo jalkelainen) {
        lapset.add(jalkelainen);
    }

    /**
     * Palauttaa henkilön jälkeläiset listana
     *
     * @return ArrayList<Henkilo> lapset
     */
    public List<Henkilo> getLapset() {
        return lapset;
    }

    /**
     * Henkilölle voidaan lisätä puoliso Puoliso tarkoittaa tässä henkilöä,
     * jonka kanssa on yhteinen jälkeläinen
     *
     * @param puoliso Käyttäjän syöttämä henkilö
     */
    public void setPuoliso(Henkilo puoliso) {
        this.puoliso = puoliso;
    }

    /**
     * Palauttaa henkilön puolison
     *
     * @return Henkilo puoliso
     */
    public Henkilo getPuoliso() {
        return puoliso;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setSukupuoli(Sukupuoli sukupuoli) {
        this.sukupuoli = sukupuoli;
    }

    public Sukupuoli getSukupuoli() {
        return sukupuoli;
    }

    public boolean onkoSairas() {
        return sairas;
    }

    public void setSairaus(boolean sairas) {
        this.sairas = sairas;
    }

    /**
     * Palauttaa henkilöön liittyvän mutaatio-listan
     *
     * @return ArrayList<String> mutaatiot
     */
    public List<String> getMutaatiot() {
        return mutaatiot;
    }

    /**
     * Lisää uuden mutaation henkilön mutaatiolistaan
     *
     * @param mutaatio
     */
    public void lisaaMutaatio(String mutaatio) {
        this.mutaatiot.add(mutaatio);
    }

    public void setIka(int ika) {
        if (ika >= 0 && ika <= 150) {
            this.ika = ika;
        } else {
            this.ika = 0;
        }
    }

    public int getIka() {
        return ika;
    }

    public int getSukupolvi() {
        return sukupolvi;
    }

    public void setSukupolvi(int sukupolvi) {
        this.sukupolvi = sukupolvi;
    }
}
