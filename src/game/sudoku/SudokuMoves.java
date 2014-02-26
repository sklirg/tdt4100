package game.sudoku;

import java.util.Stack;

/**
 * Created by sklirg on 2/26/14.
 */
public class SudokuMoves {
    Stack<int[]> moves = new Stack<int[]>();
    Stack<int[]> fieldStates = new Stack<int[]>();

    // add ctor for boardString

    public void addMove(Field field, int[] move) {
        int[] oldField = new int[3];
        oldField[0] = move[0];
        oldField[1] = move[1];
        oldField[2] = field.getValue();
        fieldStates.push(oldField);
        moves.push(move);
    }

    public int[] undo() {
        int[] previousMove = fieldStates.peek();
        moves.push(previousMove);
        return previousMove;
    }
}
