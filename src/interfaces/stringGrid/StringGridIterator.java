package interfaces.stringGrid;

import java.util.Iterator;

/**
 * Created by sklirg on 2/21/14.
 */
public class StringGridIterator implements Iterator<String> {
    boolean hasNext, iterateRows;
    int row, col;
    StringGridImpl StringGrid;

    public StringGridIterator(StringGridImpl grid, boolean rows) {
        this.StringGrid = grid;
        this.row = 0;
        this.col = 0;
        this.hasNext = true;
        this.iterateRows = rows;
    }

    public boolean hasNext() {
        if (this.iterateRows) {
            if (this.col < this.StringGrid.getColumnCount()-1)
                return true;
            else if (this.row < this.StringGrid.getRowCount()-1)
                return true;
        }
        else {
            if (this.row < this.StringGrid.getRowCount()-1)
                return true;
            else if (this.col < this.StringGrid.getColumnCount()-1)
                return true;
        }
        return false;
    }

    public String next() {
        String r = StringGrid.getElement(row, col);

        if (this.iterateRows) {
            if (this.col < this.StringGrid.getColumnCount()) {
                this.col++;
            }
            else if (this.row < this.StringGrid.getRowCount()) {
                this.col = 0;
                this.row++;
            }
        }
        else {
            if (this.row < this.StringGrid.getRowCount()) {
                this.row++;
            }
            else if (this.col < this.StringGrid.getColumnCount()) {
                this.row = 0;
                this.col++;
            }
        }

        return r;
    }

    public void remove() {
        throw new UnsupportedOperationException("This doesn't do anything.");
    }
}
