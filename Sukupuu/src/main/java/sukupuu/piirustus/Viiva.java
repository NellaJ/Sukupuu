package sukupuu.piirustus;

import java.awt.Graphics;

/**
 * Viiva-luokkaa perii Kuvio-luokan ja perii sieltä toiset x- ja y-koordinaatit
 * sekä piirrä-metodin Luokalla on lisäksi toiset x- ja y-koordinaatit Toiset
 * koordinaatit ovat viivan lähtöpiste ja toiset viivan loppumispiste
 */
public class Viiva extends Kuvio {

    private int x2;
    private int y2;

    public Viiva(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public void piirra(Graphics graphics) {
        
        graphics.drawLine(super.getX(), super.getY(), x2, y2);
    }

    @Override
    public void varita(Graphics graphics) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
