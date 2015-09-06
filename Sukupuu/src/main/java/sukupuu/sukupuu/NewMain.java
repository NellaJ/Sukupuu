
package sukupuu.sukupuu;

import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) {
      //   (String nimi, int ika, String sairaus, boolean mutaationKantaja, String sukupolvi, String ID, String sukupuoli) {
        ArrayList<Henkilo> ihmislista;
        ihmislista = new ArrayList<>();
        
        Henkilo matti = new Henkilo("Matti Virtanen", 38, "Värisokeus", true, "II", "MV", "M");
        ihmislista.add(matti);
        Henkilo pentti = new Henkilo("Pentti Virtanen", 47, "", false, "II", "PV", "M");
        ihmislista.add(pentti);
        Henkilo saara = new Henkilo("Saara Virtanen", 28, "", true, "II", "SV", "N");
        ihmislista.add(saara);
        Henkilo tarmo = new Henkilo("Tarmo Virtanen", 98, "Värisokeus", true, "I", "TV", "M");
        ihmislista.add(tarmo);
        Henkilo irja = new Henkilo("Irja Virtanen", 87, "", true, "I", "IV", "N");
        ihmislista.add(irja);
        Henkilo pipsa = new Henkilo("Pipsa Virtanen", 25, "", true, "III", "PV", "N");
        ihmislista.add(pipsa);
        
        for (Henkilo ihminen : ihmislista) {
            ihminen.toString();
        }
        
    }
}
