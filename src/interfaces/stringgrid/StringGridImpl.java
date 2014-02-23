package interfaces.stringgrid;

/**
 * Created by sklirg on 2/21/14.
 */
public class StringGridImpl implements IStringGrid {
    String[][] stringGrid;
    int numRow, numCol;

    public StringGridImpl(int rows, int cols) {
        this.stringGrid = new String[rows][cols];
        this.numRow = rows;
        this.numCol = cols;
    }

    public int getRowCount() {
        return this.numRow;
    }

    public int getColumnCount() {
        return this.numCol;
    }

    public void setElement(int row, int col, String str) {
        //try {
        System.out.println(String.format("Setting %s, %s to %s", row, col, str));
            stringGrid[row][col] = str;
        /*}
        catch (Exception e) {
            throw new IllegalArgumentException("Something went wrong!\n" + e);
        }*/
    }

    public String getElement(int row, int col) {
       // try {
        System.out.println(String.format("Trying to access %s, %s", row, col));
//        System.out.println(stringGrid.length + " rows & " + stringGrid[0].length);
            return stringGrid[row][col];
        /*}
        catch (Exception e) {
            throw new IllegalArgumentException("HTTP 404 . There is nothing here");
        }*/
    }
}
