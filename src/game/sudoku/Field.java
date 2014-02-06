package game.sudoku;

/**
 * Created by Håkon on 30.01.14.
 */
public class Field {
    private boolean changeable, conflict;
    private int x, y, v;

    private boolean isValidField(int i) {
        return ((i>=0) && (i<=8));
    }

   /* public Field() {
        changeable = true;
        x = -1;
        y = -1;
        value = "N";
    }*/

    /*if (!(changeable)) {
        throw new IllegalArgumentException("This field is not changeable");
    }
    else*/


    public Field(int x, int y, int v) {
        if (!(isValidField(x) && isValidField(y))) {
            throw new IllegalArgumentException("These coordinates are invalid.");
        }
        else if (false) {
            throw new IllegalArgumentException("This value is invalid.");
        }
        else {

            boolean changeable;

            if (v == -1)
                changeable = true;
            else
                changeable = false;
            /*
            int wat = v;

            try {
                //System.out.print(value + " - ");
                wat = Integer.parseInt(v+"");
                //System.out.println(wat);
            }
            catch (Exception e) {
                //System.out.println(e);
                changeable = true;
            }

*/
            /*
            for (int i = 1; i < 10; i++) {
                System.out.println(String.format("v: %s, i: %s", value, i));
                if (value == i) {
                    changeable = false;
                    break;
                }
            }*/

            this.x = x;
            this.y = y;
            this.v = v;
            this.changeable = changeable;
        }
    }

    public boolean isChangeable() {
        return changeable;
    }

    public void setChangeable(boolean changeable) {
        // Can only be set in the initial phase
        this.changeable = changeable;
    }

    public boolean isConflict() {
        return conflict;
    }

    public void setConflict(boolean conflict) {
        this.conflict = conflict;
    }

    public int getValue() {
        return v;
    }

    public void setValue(int v) {
        if (!(changeable)) {
            throw new IllegalArgumentException("This field is not changeable");
        }
        else {
            this.v = v;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        // >=0 && <=8
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        // >0 && <9
        this.y = y;
    }

    @Override
    public String toString() {
        String s1 = " ", s2 = " ";
        if (!(changeable)) {
            s1 = "(";
            s2 = ")";
        }
        if (changeable && conflict) {
            s2 = "*";
        }
        return String.format("%s%s%s", s1, getValue(), s2);
    }
}
