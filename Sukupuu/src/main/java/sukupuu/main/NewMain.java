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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnsimmainenSukupolvi().setVisible(true);
            }
        });

    }
}

