package encapsulation;

/**
 * Created by Håkon on 22.01.14.
 */
public class Location {
    // [1] Private vars
    private int x;
    private int y;
    private int minX, minY, maxX, maxY;

    // [1] Public methods
    public Location() {
        x = 0;
        y = 0;
    }

    void up() {
        if (isValidCoordinates(x,y)) {
            x--;
        }
    }

    void down() {
        if (isValidCoordinates(x,y)) {
            x++;
        }
    }

    void left() {
        if (isValidCoordinates(x,y)) {
            y--;
        }
    }

    void right() {
        if (isValidCoordinates(x,y)) {
            y++;
        }
    }

    public boolean isValidCoordinates(int x, int y) {
        return ((x >= minX && x <= maxX) && (y >= minY && y <= maxY));
    }

    /*
     *
     * [2] ^ [3]
     *
     *  Del 2:
     * Øke x og y med økningen i maxX og maxY (maxX += z, x += z)
     *
     * Burde heller lage et nytt objekt dersom man skal endre slike verdier...
     *
     */
}
