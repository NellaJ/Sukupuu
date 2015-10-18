package sukupuu.piirustuslogiikka;

import java.util.ArrayList;

/**
 * Koordinaatti sisältää x-koordinaatin, y-koordinaatin ja boolean-muuttujan
 * vapaana.
 *
 */
public class Koordinaatti {

    private int x;
    private int y;
    private boolean vapaana;

    public Koordinaatti(int x, int y, boolean arvo) {
        this.x = x;
        this.y = y;
        this.vapaana = arvo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVapaana() {
        return vapaana;
    }

    public void setVapaana(boolean vapaana) {
        this.vapaana = vapaana;
    }
}
