package stateandbehavior;

import javax.crypto.IllegalBlockSizeException;

/**
 * Created by Sklirg on 20.01.14.
 */
public class UpOrDownCounter {
    int counter;
    int end;
    boolean up;

    UpOrDownCounter(int start, int end) {
        counter = start;
        this.end = end;
        if (end > start) {
            up = true;
        }
        else if (start == end) {
            throw new IllegalArgumentException ("123");
        }
        else {
            up = false;
        }
    }

    public int getCounter() {
        return counter;
    }

    boolean count() {
        boolean counted = false;
        if ((up)&& (counter < end)) {
            counter++;
        }

        if ((!up) && (counter > end)) {
            counter--;
        }
        //System.out.println("Counter is naow : " + counter + " : ");
        return !(counter==end);
    }

    public static void main (String[] Args) {
        UpOrDownCounter c = new UpOrDownCounter(1, 5);

        System.out.println(c.getCounter());
        System.out.println(c.count());
        System.out.println(c.getCounter());
        System.out.println(c.count());
        System.out.println(c.getCounter());
        System.out.println(c.count());
        System.out.println(c.getCounter());
        System.out.println(c.count());
        System.out.println(c.getCounter());
        System.out.println(c.count());
    }
}