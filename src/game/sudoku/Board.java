package game.sudoku;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Håkon on 30.01.14.
 */
public class Board {

    /*
    * Tall i parenteser: tall som ikke kan endres
    * Tall uten parenteser: tall satt av spilleren
    * Punktum: tom rute
    * Asterisk/stjerne: tall satt av spilleren, i konflikt
    *
    */

    private Field[][] board = new Field[9][9];

    public Board(String boardInitString) {
        if (boardInitString.length() != 81) {
            throw new IllegalArgumentException(String.format("The length of the initialization string should be exactly 81 chars. [%s]" , boardInitString.length()));
        }
        else {
            int counter = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    int v = 0;
                    char s = boardInitString.charAt(counter);
                    if (s == '.')
                        v = -1;
                    else
                        v = Integer.parseInt(s+"");

                    board[i][j] = new Field(j,i,v);

                    counter++;
                }
            }
        }
    }

    public void findConflicts() {
        int[] rowNums = new int[9];
        int[] colNums = new int[9];
        int[] numOccurences = {0,0,0,0,0,0,0,0,0};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getValue() != -1)
                    numOccurences[board[i][j].getValue()]++;
            }
            for (int j = 0; j < board.length; j++) {
                if (numOccurences[j] > 1) {
                    for (int k = 0; k < board.length; k++) {
                        if (board[i][j].getValue() == j) {
                            board[i][j].setConflict(true);
                        }
                    }
                }
            }
        }

    }

    public String getBoard() {
        String spacer = "  +---------+---------+---------+";
        String r = spacer+"\n";
        int rowCounter = 0;

        for (int i = 0; i < board.length; i++) {
            r += (i+1) + " |";
            int colCounter = 0;
            for (int j = 0; j < board.length; j++) {
                int v = board[i][j].getValue();
                if (v == -1)
                    r += " . ";
                else
                    r += board[i][j];
                colCounter++;
                if (colCounter%3 == 0) {
                    r += "|";
                }
            }
            rowCounter++;
            if (rowCounter % 3 == 0)
                r += "\n" + spacer;
            r += "\n";
        }
        r += "  + a  b  c + d  e  f + g  h  i +";
        return r;
    }

    public void setValue(int[] i) {
        board[i[1]][i[0]].setValue(i[2]);
    }

    @Override
    public String toString() {
        return getBoard();
    }
}
