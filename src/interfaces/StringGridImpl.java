package interfaces;

import java.util.ArrayList;

/**
 * Created by sklirg on 2/21/14.
 */
public class StringGridImpl implements IStringGrid {
    ArrayList<ArrayList<String>> stringGrid = new ArrayList<ArrayList<String>>();

    /* @ToDo
     * Constructor
     */
    /*public StringGridImpl() {

    }
    */

    public int getRowCount() {
        return stringGrid.size();
    }

    public int getColumnCount() {
        try {
            return stringGrid.get(0).size();
        }
        catch (Exception e) {
            return -1;
        }
    }

    public void setElement(int row, int col, String str) {
        try {
            stringGrid.get(row).add(col, str);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Something went wrong!\n" + e);
        }
    }

    public String getElement(int row, int col) {
        try {
            return stringGrid.get(row).get(col);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("HTTP 404 . There is nothing here");
        }
    }
}
