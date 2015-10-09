
package sukupuu.main;

import java.util.ArrayList;
import sukupuu.GraafinenKayttis.Graafinen;
import sukupuu.henkilo.Henkilo;


public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graafinen().setVisible(true);
            }
        });

    }
}

