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
        int[] thing = new int[3];
        thing[0] = field.getY()+1;
        thing[1] = field.getX();
        thing[2] = newValue;
        fieldStates.push(thing);
    }

    public int[] undo() {
        int[] undoneMove = moves.peek();
        System.out.println(moves.peek()[0]+""+moves.peek()[1]+""+moves.peek()[2] + " & " + fieldStates.peek()[0]+""+fieldStates.peek()[1]+""+fieldStates.peek()[2]);
        return undoneMove;
        //return String.format("%s%s%s", p[0], p[1], p[2]);
    }

    public String peek() {
        return /*String.format("%s", */moves.peek()+""/*)*/;
    }

    public String pop() {
        int[] p = fieldStates.pop();
        return String.format("%s%s%s", p[0], p[1], p[2]);
    }
}
