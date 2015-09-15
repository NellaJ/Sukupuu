package piirustus;

import java.awt.Graphics;

public abstract class Kuvio {

    private int x;
    private int y;

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

    public abstract void piirra(Graphics graphics);
}
