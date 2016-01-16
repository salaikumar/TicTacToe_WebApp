package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import tictactoe.Game;

/**
 * Tic Tac Toe Constructor
 * Handles all the actions corresponding to Tic Tac Toe Game
 */
public class TicTacToe extends Controller {

    private Game game;

    public void ping(){
        if (game == null)
            throw new RuntimeException("Game is not initialized");
    }

    /*
     * User will supply size and marks.
     * Create game instance with it.
     */
    public Result start(int size, int marks){
        game = new Game(size,marks);
        return ok();
    }

    /*
     * move - humanMove- Cell coordinates will be given by user
     */
    public void move(String move){

        if (game == null)
            throw new RuntimeException("Game is not initialized");

        /*
         * 1. Make human move
         * 2. Check for gameOver - Yes - Prepare final Status and return
         * 3. Make bot move
         * 4. Check for gameOver - Yes - Prepare final Status  and return
         * 5. Prepare intermediate Game Status and return
         */

         game.humanMove(move);
         if (!game.isGameOver())
             game.botMove(game.freePosition());
         else {
//           Final Status and Return
         }
         if (!game.isGameOver()) {
//           Final Status and Return
         }
         else {
//          intermediate Status and Return
         }

        }
}
