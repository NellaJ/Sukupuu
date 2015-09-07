package sukupuu.sukupuu;

import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) {
        ArrayList<Henkilo> ihmislista = new ArrayList<>();

        Henkilo eka = new Henkilo("MV", 38, "HCM", true, "M");
        ihmislista.add(eka);
        Henkilo toka = new Henkilo("PV", 47, "", false, "M");
        ihmislista.add(toka);
        Henkilo kolmas = new Henkilo("SV", 28, "", true, "N");
        ihmislista.add(kolmas);
        Henkilo neljas = new Henkilo("TV");
        ihmislista.add(neljas);
        Henkilo viides = new Henkilo("IV");
        viides.setIka(88);
        viides.setMutaationKantaja(true);
        ihmislista.add(viides);
        Henkilo kuudes = new Henkilo("HI");
        kuudes.setSukupuoli("M");
        ihmislista.add(kuudes);

        for (Henkilo ihminen : ihmislista) {
            ihminen.toString();
        }

    }
}
