package game.sudoku;

import java.util.Stack;

/**
 * Created by sklirg on 2/26/14.
 */
public class SudokuMoves {
    Stack<int[]> moves = new Stack<int[]>();
    Stack<int[]> fieldStates = new Stack<int[]>();

    // add ctor for boardString to save game

    public void addMove(Field field, int newValue) {
        // Do this:
        /*
         * Field
         * oldValue, newValue
         * return field newValue
         */
        int[] move = new int[3];
        move[0] = field.getX();
        move[1] = field.getY();
        move[2] = field.getValue();
        moves.push(move);
    }

    public int[] undo() {
        int[] undoneMove = moves.peek();
        //System.out.println(String.format("State: [%s, %s] %s", previousMove[0], previousMove[1], previousMove[2]));
        //return previousMove;
        return undoneMove;
    }

    public String peek() {
        return /*String.format("%s", */moves.peek()+""/*)*/;
    }
}
