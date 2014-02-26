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
                return false;
        }

        return false;
        //return !(this.row > this.StringGrid.getRowCount() && this.col > this.StringGrid.getColumnCount());
    }

    public String next() {
        String r = StringGrid.getElement(row, col);

        if (this.iterateRows) {
            if (this.col < this.StringGrid.getColumnCount()-1) {
                this.col++;
            }
            else if (this.row < this.StringGrid.getRowCount()-1) {
                this.col = 0;
                this.row++;
            }
            else {
                // what to do if reached end
                //throw new IllegalArgumentException("NO!");
            }
        }
        else {
            if (this.row < this.StringGrid.getRowCount()-1) {
                this.row++;
            }
            else if (this.col < this.StringGrid.getColumnCount()-1) {
                this.row = 0;
                this.col++;
            }
            else {
                // what to do if reached end
                //throw new IllegalArgumentException("ROW NOW!");
            }
        }

        return r;
    }

    public void remove() {
        throw new UnsupportedOperationException("This doesn't do anything.");
    }
}
