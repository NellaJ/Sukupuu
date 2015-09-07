package sukupuu.sukupuu;

public class Henkilo {

    private String nimi;
    private int ika;
    private String sairaus;
    private boolean mutaationKantaja;
    private String sukupolvi;
    private String sukupuoli;

    Henkilo(String nimi) {
        this.ika = 0;
        this.sairaus = "";
        this.mutaationKantaja = false;
        this.sukupuoli = "";
        this.sukupolvi = "";
        this.nimi = nimi;

    }

    public Henkilo(String nimi, int ika, String sairaus, boolean mutaationKantaja, String sukupuoli) {
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

    @Override
    public String toString() {
        System.out.println("Henkilö " + this.nimi + " " + this.ika + " vuotta." + "Kantaa mutaatiota? " + this.mutaationKantaja + " Sukupuoli: " + this.sukupuoli);
        return super.toString();
    }

    public void setSukupuoli(String sukupuoli) {
        this.sukupuoli = sukupuoli;
    }

    public String getSukupuoli() {
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

    public void setIka(int ika) {
        this.ika = ika;
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
