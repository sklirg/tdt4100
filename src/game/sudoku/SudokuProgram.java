package game.sudoku;

/**
 * Created by Håkon on 31.01.14.
 */
public class SudokuProgram {
    private String board;
    private boolean gameInProgress;

    private boolean validBoardString(String s) {
        char[] validChars = {'1','2','3','4','5','6','7','8','9','.'};
        boolean validChar = false;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < validChars.length; j++) {
                if (s.charAt(i) == validChars[j]){
                    validChar = true;
                    break;
                }
            }
            if (!(validChar))
                return false;
        }

        return true;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }
    // vars


    public String getBoard() {
        return board;
    }

    public void setBoard(String boardInitString) {
        if (boardInitString.length() != 81) {
            throw new IllegalArgumentException(String.format("The length of the initialization string should be exactly 81 chars. [%s]" , boardInitString.length()));
        }
        else if (gameInProgress) {
            throw new IllegalArgumentException("This game already has an active board.");
        }
        else if (!(validBoardString(boardInitString))) {
            throw new IllegalArgumentException("This boardString contains invalid characters.");
        }
        else {
            this.board = boardInitString;
            this.setGameInProgress(true);
        }
    }

    public int[] translateInput(String input) {
        char[] chars = {'a','b','c','d','e','f','g','h','i'};
        char[] coordinates = input.toCharArray();
        boolean emptyThisField = false;
        int x = 0;
        int y = -1;
        int v = 0;

        if (coordinates[2] == '.') {
            v = -1;
            emptyThisField = true;
        }

        try {
            x = Integer.parseInt(coordinates[0]+"")-1;
            if (!(emptyThisField))
                v = Integer.parseInt(coordinates[2]+"")-1;
            for (int i = 0; i < chars.length; i++) {
               if (chars[i] == coordinates[1]) {
                    y = i;
                    break;
                }
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid values.");
        }

        if (y == -1)
            throw new IllegalArgumentException("Invalid second value.");
        if (((x < 0) || (x > 8)) || (((v < 0) || (v > 8)) && !(emptyThisField)))
            throw new IllegalArgumentException("Invalid values, must be >= 1 and <= 9 ");
        if (coordinates.length > 3)
            throw new IllegalArgumentException("You supplied too many arguments");


        int[] r = {x,y,v};
        return r;
    }

    public void init() {
        if (gameInProgress) {
            throw new IllegalStateException("Game is already in game.");
        }
        else {
            Board gameBoard = new Board(board);
        }
    }

    public static void main(String[] args) {
        SudokuProgram game = new SudokuProgram();
        game.setBoard(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....");
        game.init();

        game.translateInput("1a1");
    }
}
