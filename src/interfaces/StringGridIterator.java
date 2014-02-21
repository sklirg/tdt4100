package interfaces;

import java.util.Iterator;

/**
 * Created by sklirg on 2/21/14.
 */
public class StringGridIterator implements Iterator<String> {

    public boolean hasNext() {
        return false;
    }

    public String next() {
        StringGridImpl r = new StringGridImpl();
        return r.getElement(0,0);
    }

    public void remove() {
        // Do Stuff
    }
}
