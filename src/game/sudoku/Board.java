package game.sudoku;

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
                    board[i][j] = new Field(j,i,boardInitString.charAt(counter));

                    counter++;
                }
            }
        }
    }

    public String getBoard() {
        //DEBUG
        String spacer = "+---------+---------+---------+";
        String r = spacer+"\n";
        int rowCounter = 0;
        for (int i = 0; i < board.length; i++) {
            r += "|";
            int colCounter = 0;
            for (int j = 0; j < board.length; j++) {
                r += String.format("%s",board[i][j]);
                colCounter++;
                if (colCounter%3 == 0) {
                    r += "|";
                }
            }
            rowCounter++;
            if (rowCounter % 3 == 0) {
                r += "\n" + spacer;
            }
            r += "\n";
        }
        return r;
    }

    public void setValue(int x, int y, char value) {
        board[y][x].setValue(value);
    }

    public static void main(String[] args) {
        Board board1 = new Board(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....");
        board1.setValue(0,2,'1');
        System.out.println(board1.getBoard());


    }
}
