package sukupuu;

import java.util.ArrayList;

public class NewMain {
    
    //Alussa voi testata henkilöluokkaa täältä
    public static void main(String[] args) {
        ArrayList<Henkilo> ihmislista = new ArrayList<>();

        Henkilo eka = new Henkilo("MV", 38, "HCM", true, Sukupuoli.MIES);
        ihmislista.add(eka);
        Henkilo toka = new Henkilo("PV", 47, "", false, Sukupuoli.MIES);
        ihmislista.add(toka);
        Henkilo kolmas = new Henkilo("SV", 28, "", true, Sukupuoli.NAINEN);
        ihmislista.add(kolmas);
        Henkilo neljas = new Henkilo("TV");
        ihmislista.add(neljas);
        Henkilo viides = new Henkilo("IV");
        viides.setIka(88);
        viides.setMutaationKantaja(true);
        ihmislista.add(viides);
        Henkilo kuudes = new Henkilo("HI");
        kuudes.setSukupuoli(Sukupuoli.MIES);
        ihmislista.add(kuudes);

        for (Henkilo ihminen : ihmislista) {
            ihminen.toString();
        }

    }
}
