
package piirustus;

import java.awt.Graphics;

public class Viiva extends Kuvio {
    
    private int x2;
    private int y2;
    
    public Viiva(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.drawLine(super.getX(), super.getY(), x2, y2);
    }
    
}
