package interfaces.stringgrid;

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

    /*private int[] getNext() {

    }*/

    public boolean hasNext() {
        return !(this.row > this.StringGrid.getRowCount() && this.col > this.StringGrid.getColumnCount());
    }

    public String next() {
        String r = StringGrid.getElement(row, col);

        if (this.iterateRows) {
            System.out.println(String.format("iter row: [%s,%s]", row, col));
            if (this.col < this.StringGrid.getColumnCount()-1) {
                this.col++;
            }
            else if (this.row < this.StringGrid.getRowCount()-1) {
                this.col = 0;
                this.row++;
            }
            else {
                // what to do if reached end
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
            }
        }

        return r;
    }

    public void remove() {
        throw new UnsupportedOperationException("This doesn't do anything.");
    }
}
