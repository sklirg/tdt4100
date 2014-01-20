package stateandbehavior;

public class Rectangle {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    //private boolean first = true;
    //private boolean second = false;

/*    public Rectangle() {

        minX = 1000;
        minY = 1000;
        maxX = -1000;
        maxY = -1000;

    }
*/
    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public int getWidth() {
        if ((maxX-minX == 0 || maxY-minY == 0) && !(maxX-minX == 0 && maxY-minY == 0)) {
            return 1;
        }
        else if (isEmpty()) {
            return 0;
        }
        else {
            return (maxX - minX);
        }
    }

    public int getHeight() {
        if ((maxX-minX == 0 || maxY-minY == 0) && !(maxX-minX == 0 && maxY-minY == 0)) {
            return 1;
        }
        else if (isEmpty()) {
            return 0;
        }
        else  {
            return (maxY-minY);
        }
    }

    public boolean isEmpty() {
        return ((maxY-minY == 0) || (maxX - minX == 0));
    }

    public boolean contains(int x, int y) {

        /*if (isEmpty()) {
            return false;
        }
        else*/ if ((x>=minX) && (x<=maxX) && (y>=minY) && (y<=maxY)) {

        if (isEmpty()) {
            return false;
        }
        else if ((x>=minX) && (x<=maxX) && (y>=minY) && (y<=maxY)) {

            return true;
        }
        else {
            return false;
        }
    }

    public boolean contains(Rectangle rect) {
        if (isEmpty() || rect.isEmpty()) {
            return false;
        }
        else {
            minX = rect.getMinX();
            minY = rect.getMinY();
            maxX = rect.getMaxX();
            maxY = rect.getMaxY();
            return ((contains(minX, minY)) && (contains(maxX,maxY)));
        }
    }

    public boolean add(int x, int y) {
        boolean changed = false;


        /*
        if (contains(x, y)) {
            return false;
        }
        else {*/
            if (minX == 0 && maxX == 0) {
                minX = x;
                maxX = x;
                changed = true;
            }
            if (minY == 0 && maxY == 0) {
                minY = y;
                maxY = y;
                changed = true;
            }


        //if (first) { second = true; first = false; }

        if (contains(x, y)) {
            return false;
        }
        /*else if (isEmpty()) {
            minX = x;
            maxX = x;
            minY = y;
            maxY = y;
            //first = false;
            return true;
        }*/
        else {

            if (x < minX) {
                minX = x;
                changed = true;
            }

            if (x > maxX) {
                maxX = x;
                changed = true;
            }

            if (y < minY) {
                minY = y;
                changed = true;
            }

            if (y > maxY) {
                maxY = y;
                changed = true;
            }


            return changed;
        }
    //}

            return changed;
        }
    }


    public boolean add(Rectangle rect) {
        if (rect.isEmpty()) {
            return false;
        }
        else {
            boolean changed = false;

            if (add(rect.getMinX(), getMinY())) {
                changed = true;
            }
            if (add(rect.getMaxX(), getMaxY())) {
                changed = true;
            }
            /*
            if (x < minX) {
                minX = x;
                changed = true;
            }

            if (x > maxX) {
                maxX = x;
                changed = true;
            }

            if (y < minY) {
                minY = y;
                changed = true;
            }

            if (y > maxY) {
                maxY = y;
                changed = true;
            }
            */
            return changed;
        }
    }

    public Rectangle union(Rectangle rect) {
        return rect;
    }

    public static void main (String[] Args) {
        /*Rectangle rect = new Rectangle();
        System.out.println(rect.isEmpty());
        rect.setMinX(1);
        rect.setMaxX(10);
        System.out.println(rect.getMinX());
        System.out.println(rect.getMaxX());
        System.out.println(rect.getWidth());
        System.out.println(rect.isEmpty());

        rect.setMinY(1);
        rect.setMaxY(10);
        System.out.println(rect.getMinY());
        System.out.println(rect.getMaxY());
        System.out.println(rect.getHeight());
        System.out.println(rect.isEmpty());*/

        System.out.println("Rectangle 2");
        Rectangle rect2 = new Rectangle();
        System.out.println(rect2.add(13,-27));

        System.out.println(rect2.add(13,-27));
        //System.out.println(rect2.add(10,10));
        System.out.println(rect2.contains(13, -27));
        //System.out.println(rect2.contains(10,10));

        System.out.println(rect2.add(10,10));
        System.out.println(rect2.contains(13, -27));
        System.out.println(rect2.contains(10,10));

        System.out.println("----X---");
        System.out.println("min: "+rect2.getMinX());
        System.out.println("max: "+rect2.getMaxX());
        System.out.println("----Y---");
        System.out.println("min: "+rect2.getMinY());
        System.out.println("max: "+rect2.getMaxY());
        System.out.println("--------");
        System.out.println(rect2.getWidth());
        System.out.println(rect2.getHeight());
        System.out.println(rect2.isEmpty());
    }
}
