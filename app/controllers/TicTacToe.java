package controllers;


import play.data.validation.Constraints;
import play.mvc.Controller;
import play.mvc.Result;
import tictactoe.Game;
import tictactoe.GameStatus;
import views.html.index;
import views.html.move;

import static sun.plugin2.util.PojoUtil.toJson;

/**
 * Tic Tac Toe Constructor
 * Handles all the actions corresponding to Tic Tac Toe Game
 */
public class TicTacToe extends Controller {

    private Game game;

    public Result ping(){
        if (game == null)
            throw new RuntimeException("Game is not initialized");
        return ok(toJson("Status:Alive"));
    }

    /*
     * User will supply size and marks.
     * Create game instance with it.
     */
    public Result start(int size, int marks){
        game = new Game(size,marks);
        return ok(index.render("Game initiated. Post your move to /move as single String X|Y "));
    }

    /*
     * move - humanMove- Cell coordinates will be given by user
     * Assumption: User will post proper input. - Bad input is not handled here
     */
    public Result move(String moves){
        if (game == null)
            throw new RuntimeException("Game is not initialized");
        /*
         * 1. Make human move
         * 2. Check for gameOver - Yes - Prepare final Status and return
         * 3. Make bot move
         * 4. Check for gameOver - Yes - Prepare final Status  and return
         * 5. Prepare intermediate Game Status and return
         */
         game.humanMove(moves);
         if (game.isGameOver())
             return ok(toJson(prepareStatus(true,"Game Ended")));

         game.botMove(game.freePosition());
         if (game.isGameOver())
             return ok(toJson(prepareStatus(true,"Game Ended")));

         return ok(toJson(prepareStatus(false,"Game running")));
    }

    private GameStatus prepareStatus(boolean isGameOver,String message){
        GameStatus gameStatus = new GameStatus();
        gameStatus.setBoard(game.getBoard().toString());
        gameStatus.setIsGameOver(isGameOver);
        gameStatus.setMessage(message);
        gameStatus.setWinMoves(game.getBoardStatus().getMarks());
        gameStatus.setStatus("OK");

        if (isGameOver)
            gameStatus.setWinner(game.getWinner());

        return gameStatus;
    }
}
