package piirustus;

import java.awt.Graphics;

public class Nelio extends Kuvio {

    private int sivunPituus;

    public Nelio(int x, int y, int sivunPituus) {
        super(x, y);
        this.sivunPituus = sivunPituus;
    }

    public int getSivunPituus() {
        return sivunPituus;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.fillRect(super.getX(), super.getY(), sivunPituus, sivunPituus);
    }
}
