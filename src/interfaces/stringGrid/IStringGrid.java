package interfaces.stringGrid;

/**
 * Created by sklirg on 2/21/14.
 */
public interface IStringGrid {

    public int getRowCount();

    public int getColumnCount();

    public String getElement(int row, int column);

    public void setElement(int row, int column, String str);
}
