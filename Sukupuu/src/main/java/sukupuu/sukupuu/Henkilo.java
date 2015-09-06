package sukupuu.sukupuu;

public class Henkilo {

    private String nimi;
    private int ika;
    private String sairaus;
    private boolean mutaationKantaja;
    private String sukupolvi;
    private String ID;
    private String sukupuoli;

    public Henkilo(String nimi, String sukupuoli) {
        this.nimi = nimi;
        this.sukupuoli = sukupuoli;
    }

    public Henkilo(String nimi, int ika, String sairaus, boolean mutaationKantaja, String sukupolvi, String ID, String sukupuoli) {
        this.nimi = nimi;
        this.ika = ika;
        this.sairaus = sairaus;
        this.mutaationKantaja = mutaationKantaja;
        this.sukupolvi = sukupolvi;
        this.ID = ID;
        this.sukupuoli = sukupuoli;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        System.out.println("Nimi: " + this.nimi + " ikä: " + this.ika + " Sairaus: " + this.sairaus + " Kantaako mutaatiota? " + this.mutaationKantaja + " Sukupuoli: " + this.sukupuoli);
        return null;
    }

    public void setSukupolvi(String sukupolvi) {
        this.sukupolvi = sukupolvi;
    }

    public void setSairaus(String sairaus) {
        this.sairaus = sairaus;
    }

    public void setMutaationKantaja(boolean mutaationKantaja) {
        this.mutaationKantaja = mutaationKantaja;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSukupolvi() {
        return sukupolvi;
    }

    public boolean isMutaationKantaja() {
        return mutaationKantaja;
    }

    public String getSairaus() {
        return sairaus;
    }

    public int getIka() {
        return ika;
    }

    public String getID() {
        return ID;
    }

    public void setSukupuoli(String sukupuoli) {
        this.sukupuoli = sukupuoli;
    }

    public String getSukupuoli() {
        return sukupuoli;
    }
}
