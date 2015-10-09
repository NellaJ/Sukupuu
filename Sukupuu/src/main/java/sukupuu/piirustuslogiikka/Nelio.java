package sukupuu.piirustuslogiikka;

import java.awt.Graphics;

/**
 * Nelio-luokka joka perii luokan Kuvio Luokka perii Kuvio-luokalta x- ja
 * y-koordinaatin ja piirra-metodin lisäksi Nelio-luokalla on muuttuja
 * sivunPituus ja vari
 */
public class Nelio extends Kuvio {

    private int sivunPituus;
    private boolean vari;

    public Nelio(int x, int y, int sivunPituus) {
        super(x, y);
        this.sivunPituus = sivunPituus;
        this.vari = false;
    }

    public int getSivunPituus() {
        return sivunPituus;
    }

    /**
     * Värittää neliön
     * @param graphics
     */
    @Override
    public void varita(Graphics graphics) {
        graphics.fillRect(super.getX(), super.getY(), sivunPituus, sivunPituus);
    }
    
    /**
     * Piirtää neliön
     * @param graphics
     */
    @Override
    public void piirra(Graphics graphics) {
        graphics.drawRect(super.getX(), super.getY(), sivunPituus, sivunPituus);
    }
}
