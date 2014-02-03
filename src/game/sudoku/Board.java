package game.sudoku;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Håkon on 30.01.14.
 */
public class Board {
    private boolean gameCompleted = false;

    public boolean isGameCompleted() {
        return gameCompleted;
    }

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
        int numConflicts = 0;
        int numLeft = 9*9;

        for (int i = 0; i < board.length; i++) {
            int[] numRowOccurences = {0,0,0,0,0,0,0,0,0};
            int[] numColOccurences = {0,0,0,0,0,0,0,0,0};
            //int[] numSqOccurences = {0,0,0,0,0,0,0,0,0};

            // Finding conflicting fields
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getValue() != -1) {
                    numRowOccurences[board[i][j].getValue()-1]++;
                    numLeft--;
                }
                if (board[j][i].getValue() != -1)
                    numColOccurences[board[j][i].getValue()-1]++;
            }

            // Find conflicting fields in each "square"
            if (i == 0 || i == 3 || i == 6) {
                System.out.println("Correct row");
                for (int l = 0; l < 3; l++) {
                    int[] numSqOccurences = {0,0,0,0,0,0,0,0,0};
                    for (int j = i; j < (i+3); j++) {
                        for (int k = 0; k < 3; k++) {
                            System.out.println(String.format("[%s, %s] j %s, k %s, i %s, l %s, val %s, ",j,i+k+(l*3),j,k,i,l, board[j][k+i+l].getValue()));
                            if (board[j][k+i+l].getValue() != -1) {
                                //System.out.print(board[j][k+i].getValue()+ " ");
                                numSqOccurences[board[j][k+i+(l*3)].getValue()-1]++;
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("END --> Checking for conflict if conflicts");

                }

            }

            // Punishing conflicting fields
            for (int j = 0; j < board.length; j++) {
                if (numRowOccurences[j] > 1) {
                    for (int k = 0; k < board.length; k++) {
                        if (board[i][k].getValue()-1 == j) {
                            board[i][k].setConflict(true);
                            numConflicts++;
                        }
                    }
                }
                if (numColOccurences[j] > 1) {
                    for (int k = 0; k < board.length; k++) {
                        if (board[k][i].getValue()-1 == j) {
                            board[k][i].setConflict(true);
                            numConflicts++;
                        }
                    }
                }/*
                if (numSqOccurences[j] > 1) {
                    //System.out.println("More than one occurence of " + (j+1) + " in this square!");
                    for (int l = i; l < (i+3); l++) {
                        for (int k = 0; k < 3; k++) {
                            if (board[l][k+i].getValue()-1 == j) {
                                System.out.println("Found the invalid value: " + j);
                                board[l][k+i].setConflict(true);
                                numConflicts++;
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("END");
                }*/
            }
        }
        System.out.println(String.format("Conflicts: %s, numLeft: %s",numConflicts,numLeft));
        if (numConflicts == 0 && numLeft == 0) {
            this.gameCompleted = true;
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
        board[i[1]][i[0]].setConflict(false);
    }

    @Override
    public String toString() {
        return getBoard();
    }
}
