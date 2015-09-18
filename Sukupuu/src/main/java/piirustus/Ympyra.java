package piirustus;

import java.awt.Graphics;

public class Ympyra extends Kuvio {

    private int halkaisija;

    public Ympyra(int x, int y, int halkaisija) {
        super(x, y);
        this.halkaisija = halkaisija;
    }

    public int getHalkaisija() {
        return halkaisija;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.fillOval(super.getX(), super.getY(), halkaisija, halkaisija);
    }

}
