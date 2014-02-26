package game.sudoku;

import stateandbehavior.Stack;

import java.util.Scanner;

/**
 * Created by Håkon on 31.01.14.
 */
public class SudokuProgram {
    private String boardString;
    private boolean gameInProgress;
    Board gameBoard;

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


    public String getBoardString() {
        return boardString;
    }

    public void setBoardString(String boardInitString) {
        if (boardInitString.length() != 81) {
            throw new IllegalArgumentException(String.format("The length of the initialization string should be exactly 81 chars. [%s]" , boardInitString.length()));
        }
        else if (gameInProgress) {
            throw new IllegalArgumentException("This game already has an active boardString.");
        }
        else if (!(validBoardString(boardInitString))) {
            throw new IllegalArgumentException("This boardString contains invalid characters.");
        }
        else {
            this.boardString = boardInitString;
            //this.setGameInProgress(true);
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
                v = Integer.parseInt(coordinates[2]+"");
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
        if (((x < 0) || (x > 8)) || (((v < 0) || (v > 9)) && !(emptyThisField)))
            throw new IllegalArgumentException("Invalid values, must be >= 1 and <= 9 ");
        if (coordinates.length != 3)
            throw new IllegalArgumentException("You supplied an illegal amount of arguments");


        int[] r = {y,x,v};
        return r;
    }

    public boolean gameCompleted() {
        return gameBoard.isGameCompleted();
    }

    public void init() {
        if (gameInProgress) {
            throw new IllegalStateException("There is already an active game.");
        }
        else if (boardString.length() != 81) {
            throw new IllegalArgumentException("The boardString string must be 81 chars long.");
        }
        else {
            gameBoard = new Board(boardString);
            setGameInProgress(true);
        }
    }

    public void run() {
        Scanner scan = new Scanner(System.in);

        Stack gameMoves = new Stack();
        String undo = "";

        int moves = 0; // Not implemented.
        while (gameInProgress) {
            gameBoard.findConflicts();
            System.out.println(gameBoard.getBoard());
            System.out.println("Please select your next move.");
            String input = scan.nextLine();
            String lastMove = gameMoves.peek(0);
            if (input.length() == 3) {
                boolean legalMove = true;
                try {
                    gameBoard.setValue(translateInput(input));
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Something went wrong: " + e);
                    legalMove = false;
                }
                if (legalMove) {
                    gameMoves.push(input);
                    //System.out.println("Added move to stack - top elem in stack: " + gameMoves.peek(0));
                    moves++;
                }
            }
            else if (input.equals("u")) {
                String previousMove = gameMoves.pop();
                gameBoard.setValue(translateInput(previousMove));
                undo = previousMove;
            }
            else if (input.equals("r") && lastMove.equals("u")) {
                gameBoard.setValue(translateInput(undo));
            }
            else if (input.equals("q"))
                System.exit(0);
            else
                System.out.println("Please use this format: 1a1 [x,y,value].");
            gameBoard.findConflicts();
            if (gameCompleted()) {
                gameInProgress = false;
                System.out.println("Congratulations! You solved the puzzle!");
                break;
            }
        }

    }

    public static void main(String[] args) {
        /*
         * Ønskelig å ikke bruke Exceptions til feilmeldinger da det stopper spillet.
         */
        SudokuProgram game = new SudokuProgram();
        game.setBoardString(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8....."); // Initial boardstring
        //game.setBoardString("..7582693862739451593614872928145367736928145451367928684273519379451286215896734"); // To prove ending without solving puzzle
        game.init();
        game.run();
    }
}
