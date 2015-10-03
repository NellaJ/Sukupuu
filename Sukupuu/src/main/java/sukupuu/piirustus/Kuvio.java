package sukupuu.piirustus;

import java.awt.Graphics;

/**
 * Kuvio-luokka jossa x- ja y-koordinaatti sekä abstract piirra-metodi
 */
public abstract class Kuvio {

    private int x;
    private int y;
    private boolean vari;

    public Kuvio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setVari(boolean vari) {
        this.vari = vari;
    }

    public boolean isVari() {
        return vari;
    }

    public abstract void piirra(Graphics graphics);
    
    public abstract void varita(Graphics graphics);
}
    