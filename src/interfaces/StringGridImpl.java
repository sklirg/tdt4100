package interfaces;

import java.util.ArrayList;

/**
 * Created by sklirg on 2/21/14.
 */
public class StringGridImpl implements IStringGrid {
    ArrayList<ArrayList<String>> stringGrid = new ArrayList<ArrayList<String>>();

    /*public StringGridImpl() {

    }
    */

    public int getRowCount() {
        return stringGrid.size();
    }

    public int getColumnCount() {
        return 1; // return something useful
    }

    public void setElement(int row, int col) {
        // set
    }

    public String getElement(int row, int col) {
        return "";
    }
}
