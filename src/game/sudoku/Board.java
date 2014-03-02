package game.sudoku;
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
    private SudokuMoves moves = new SudokuMoves();

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

    private Field[] findConflicts(Field[] fields) {
        int[] occ = new int[9];
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getValue() != -1) {
                occ[fields[i].getValue()-1]++;
            }
        }
        for (int i = 0; i < fields.length; i++) {
            if (occ[i] > 1) {
                for (int j = 0; j < fields.length; j++) {
                    if (fields[j].getValue()-1 == i) {
                        fields[j].setConflict(true);
                    }
                }
            }
        }

        return fields;
    }


    private void setAllFalse(Field[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j].setConflict(false);
            }
        }
    }

    public void findConflicts() {
        int numConflicts = 0;
        int numLeft = 0;

        setAllFalse(board);

        // Count empty fields
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getValue() == -1) {
                    numLeft++;
                }
            }
        }


        // Send rows to conflictFinder func
        Field[][] fields = new Field[9][9];
        for (int i = 0; i < board.length; i++) {
             fields[i] = findConflicts(board[i]);
            for (int j = 0; j < board.length; j++) {
                if (fields[i][j].isConflict()) {
                    board[i][j].setConflict(true);
                    numConflicts++;
                }
            }
        }

        // Convert columns to "rows" and send their arrays to columnFinder func
        Field[][] rows = new Field[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                rows[i][j] = board[j][i];
            }
        }
        // The sending part
        for (int i = 0; i < rows.length; i++) {
            rows[i] = findConflicts(rows[i]);
            for (int j = 0; j < rows.length; j++) {
                if (rows[i][j].isConflict()) {
                    board[j][i].setConflict(true);
                    numConflicts++;
                }
            }
        }

        int sqLen = 3;
        Field[][] squares = new Field[9][9];
        int[][] sqStart = {{0,0},{0,3},{0,6},
                {3,0},{3,3},{3,6},
                {6,0},{6,3},{6,6}};
        for (int i = 0; i < board.length; i++) {
            int c = 0;
            for (int j = 0; j < sqLen; j++) {
                for (int k = 0; k < sqLen; k++) {
                    Field f = board[sqStart[i][0] + j][sqStart[i][1] + k];
                    squares[i][c] = f;
                    c++;
                }
            }
            squares[i] = findConflicts(squares[i]);
        }
        if (numConflicts == 0 && numLeft == 0) {
            this.gameCompleted = true;
        }
        else
            System.out.println(String.format("Number of Conflicts: %s. Numbers left: %s",numConflicts,numLeft));

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
        moves = board[i[1]][i[0]].setValue(i[2], moves);
        board[i[1]][i[0]].setConflict(false);
    }

    public void undoLastMove() {
        int[] lastMove = moves.undo();
        board[lastMove[0]][lastMove[1]].setValue(lastMove[2], moves);
    }

    @Override
    public String toString() {
        return getBoard();
    }
}
