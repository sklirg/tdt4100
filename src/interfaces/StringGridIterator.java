package interfaces;

import java.util.Iterator;

/**
 * Created by sklirg on 2/21/14.
 */
public class StringGridIterator implements Iterator<String> {
    boolean hasNext;
    int row, col;
    StringGridImpl StringGrid;

    public StringGridIterator(StringGridImpl grid, boolean rows) {
        this.StringGrid = grid;
        this.row = 0;
        this.col = 0;
        this.hasNext = true;
    }

    private int[] getNext() {
        if (this.row < this.StringGrid.getRowCount()) {
            if (this.col < this.StringGrid.getColumnCount())
                this.col++;
            else {
                this.col = 0;
                this.row++;
            }
        }
        else {
            int[] r = {-1,-1};
            this.hasNext = false;
            return r;
        }
        int[] r = {this.row, this.col};
        return r;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public String next() {
        if (hasNext) {
            int r = row, c = col;
            int[] newValues = getNext();
            this.row = newValues[0];
            this.col = newValues[1];

            return StringGrid.getElement(r,c);
        }
        else
            return "no.";
    }

    public void remove() {
        throw new UnsupportedOperationException("This doesn't do anything.");
    }
}
