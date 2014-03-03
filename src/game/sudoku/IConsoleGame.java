package game.sudoku;

import encapsulation.LineEditor;

/**
 * Created by sklirg on 3/2/14.
 */
public interface IConsoleGame {

    public void init();

    public void run();

    public Integer doLine(String input);
}
