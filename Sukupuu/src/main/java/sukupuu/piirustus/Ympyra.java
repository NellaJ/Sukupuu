package sukupuu.piirustus;

import java.awt.Graphics;

/**
 * Ympyra-luokka perii luokan Kuvio Luokka perii Kuvio-luokalta x- ja
 * y-koordinaatin ja piirra-metodin ja sillä on lisäksi muuttuja halkaisija
 */
public class Ympyra extends Kuvio {

    private int halkaisija;
    private boolean vari;

    public Ympyra(int x, int y, int halkaisija) {
        super(x, y);
        this.halkaisija = halkaisija;
        this.vari = false;
    }

    public int getHalkaisija() {
        return halkaisija;
    }

    @Override
    public void varita(Graphics graphics) {
        graphics.fillOval(super.getX(), super.getY(), halkaisija, halkaisija);
    }
    
    @Override
    public void piirra(Graphics graphics) {
        graphics.drawOval(super.getX(), super.getY(), halkaisija, halkaisija);
    }

}
