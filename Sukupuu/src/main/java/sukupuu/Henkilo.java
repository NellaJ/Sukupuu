package sukupuu;

public class Henkilo {

    //Muuttujat mutaationKantaja, sairaus ja sukupolvi luultavasti muuttuvat vielä (listoiksi tms.)

    private String nimi;
    private int ika;
    private String sairaus;
    private boolean mutaationKantaja;
    private String sukupolvi;
    private Sukupuoli sukupuoli;

    //Henkilön minimiparametrina nimi.

    public Henkilo(String nimi) {
        this.ika = 0;
        this.sairaus = "";
        this.mutaationKantaja = false;
        this.sukupuoli = Sukupuoli.MUU;
        this.sukupolvi = "";
        this.nimi = nimi;

    }

    //Toisena konstruktorina annetaan kaikki muuttujat

    public Henkilo(String nimi, int ika, String sairaus, boolean mutaationKantaja, Sukupuoli sukupuoli) {
        this.nimi = nimi;
        this.ika = ika;
        this.sairaus = sairaus;
        this.mutaationKantaja = mutaationKantaja;
        this.sukupuoli = sukupuoli;
        this.sukupolvi = "";

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
        System.out.println("Henkilö " + this.nimi + " " + this.ika + " vuotta." + "Kantaa mutaatiota? " + this.mutaationKantaja + " Sukupuoli: " + this.sukupuoli);
        return super.toString();
    }

    public void setSukupuoli(Sukupuoli sukupuoli) {
        this.sukupuoli = sukupuoli;
    }

    public Sukupuoli getSukupuoli() {
        return sukupuoli;
    }

    public String getSairaus() {
        return sairaus;
    }

    public void setSairaus(String sairaus) {
        this.sairaus = sairaus;
    }

    public void setMutaationKantaja(boolean mutaationKantaja) {
        this.mutaationKantaja = mutaationKantaja;
    }

    public boolean isMutaationKantaja() {
        return mutaationKantaja;
    }

    //Ikä ei saa olla negatiivinen

    public void setIka(int ika) {
        if (ika >= 0) {
            this.ika = ika;
        }
    }

    public int getIka() {
        return ika;
    }

    public String getSukupolvi() {
        return sukupolvi;
    }

    public void setSukupolvi(String sukupolvi) {
        this.sukupolvi = sukupolvi;
    }
}
