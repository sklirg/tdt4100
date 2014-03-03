package game.sudoku;

/**
 * Created by sklirg on 3/2/14.
 */
public interface ISaveGames {

    /* public void saveGame(int id, String boardString)
     *
     * Args:
      * int id - savegame ID, where the boardString is saved
      * String boardString - the current boardString
     *
     * Saves current game to the id specified. If id already exists, ask if user wants to overwrite.
     * Problem: Fields are marked as non-changeable if they get automatically set through the boardString,
     * this can cause problems solving the puzzle if invalid values are inserted before saving.
     *
     * Possible solution: Take in the initial boardString as argument, and the gameMovesStack,
     * then loop through the stack until board is populated.
     */
    public void saveGame(String id, String boardString);


    /* public String loadGame(int id)
     *
     * Args:
     *  int id - savegame ID, where the boardString is saved
     * Return: boardString for id
     *
     * Should ask user to save before loading
     */
    public String loadGame(String id);
}
