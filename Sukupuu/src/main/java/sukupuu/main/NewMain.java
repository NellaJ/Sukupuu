/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuu.main;

import java.util.ArrayList;
import sukupuu.GraafinenKayttis.EnsimmainenSukupolvi;
import sukupuu.sukupuu.Henkilo;

/**
 *
 * @author Hourula
 */
public class NewMain {

    public ArrayList<Henkilo> ihmislista;
    public EnsimmainenSukupolvi ekaSp;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NewMain ohjelma = new NewMain();
        ohjelma.start();
    }

    public void start() {

        java.awt.EventQueue.invokeLater(new Runnable() {
            EnsimmainenSukupolvi ekaSp = new EnsimmainenSukupolvi(ihmislista);

            @Override
            public void run() {

                ekaSp.setVisible(true);

            }

        });

    }
    //Pitäisi saada tuolta jotain uloskin. Mikään ei toimi!!!
}
