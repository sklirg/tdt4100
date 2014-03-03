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
        int[] move = new int[3];
        move[0] = field.getX();
        move[1] = field.getY();
        move[2] = field.getValue();
        moves.push(move);
    }

    public int[] undo() {
        int[] undoneMove = moves.peek();
        return undoneMove;
    }

    public String peek() {
        return /*String.format("%s", */moves.peek()+""/*)*/;
    }

    public String pop() {
        int[] p = moves.pop();
        return String.format("%s%s%s", p[0], p[1], p[2]);
    }
}
