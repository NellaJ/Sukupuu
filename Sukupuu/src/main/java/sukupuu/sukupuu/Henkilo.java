package sukupuu.sukupuu;

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

    public Henkilo(String nimi) {
        this.ika = 0;
        this.sairas = false;
        this.mutaatiot = new ArrayList<>();
        this.sukupuoli = Sukupuoli.MUU;
        this.sukupolvi = -1;        //-1 tarkoittaa, ettei sukupolvi ole tiedossa
        this.nimi = nimi;
        this.lapset = new ArrayList<>();
    }

    public Henkilo(String nimi, int ika, boolean sairas, List<String> mutaatiot, Sukupuoli sukupuoli) {
        this.nimi = nimi;
        this.ika = ika;
        this.sairas = sairas;
        this.mutaatiot = mutaatiot;
        this.sukupuoli = sukupuoli;
        this.sukupolvi = -1;
        this.lapset = new ArrayList<>();
    }

    /**
     * Konstruktorissa luotuun listaan voidaan lisätä henkilön jälkeläiset.
     * @param jalkelainen Käyttäjän syöttämä henkilö
     */
    public void lisaaLapsi(Henkilo jalkelainen) {
        lapset.add(jalkelainen);
    }

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

    public Henkilo getPuoliso() {
        return puoliso;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    //Tämä poistuu/muokkaantuu myöhemmin
    @Override
    public String toString() {
        System.out.println("Henkilö " + this.nimi + " " + this.ika + " vuotta." + " Sukupuoli: " + this.sukupuoli + " Onko sairas?: " + this.sairas);
        return super.toString();
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

    public List<String> getMutaatiot() {
        return mutaatiot;
    }

    public void lisaaMutaatio(String mutaatio) {
        this.mutaatiot.add(mutaatio);
    }

    //Ikä ei saa olla negatiivinen
    public void setIka(int ika) {
        if (ika >= 0 && ika <= 150) {
            this.ika = ika;
        } else {
            System.out.println("Syötit iän väärin!");
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
