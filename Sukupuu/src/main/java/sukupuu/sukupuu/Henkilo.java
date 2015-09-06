package sukupuu.sukupuu;

public class Henkilo {

    private String nimi;
    private int ika;
    private String sairaus;
    private boolean mutaationKantaja;
    private String sukupolvi;
    private String ID;

    Henkilo(String nimi) {
        this.ika = 0;
        this.sairaus = "";
        this.mutaationKantaja = false;
        this.sukupolvi = "";
        this.ID = "";
    }

    public Henkilo(int ika, String sairaus, boolean mutaationKantaja, String sukupolvi, String ID) {
        this.ika = ika;
        this.sairaus = sairaus;
        this.mutaationKantaja = mutaationKantaja;
        this.sukupolvi = sukupolvi;
        this.ID = ID;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        return super.toString();
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
}
