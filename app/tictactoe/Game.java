package tictactoe;


import utils.CellPosition;
import utils.Winner;

import java.util.regex.Pattern;

public class Game {

    private final Board board;
    private final BoardStatus boardStatus;

    /*
     * Constructor
     * Copy Constructor is not required by now.
     */
    public Game(int size, int marks){
        board = new Board(size);
        boardStatus = new BoardStatus(board, marks);
    }


    public Board getBoard() {
        return board;
    }

    public BoardStatus getBoardStatus() {
        return boardStatus;
    }

    /*
     * humanMove - String that contain coordinates like "M|N"
     */
    public boolean humanMove(String move){
        String[] inputs = move.split(Pattern.quote("|"));
        Integer row = Integer.parseInt(inputs[0]);
        Integer col = Integer.parseInt(inputs[1]);

        try{
            board.setHumanMove(row,col);
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }

        return true;
    }

    /*
     * botMove
     */
    public boolean botMove(CellPosition pos){
        try {
            board.setBotMove(pos.getRow(),pos.getCol());
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     * Return a free position
     */
    public CellPosition freePosition(){
        Character[][] cells = board.getAllCells();
        for (int i=1; i <= board.getSize(); ++i){
            for (int j= 1;j <= board.getSize(); ++j){
                if (board.isFree(i,j))
                    return new CellPosition(i,j);
            }
        }
        return null;
    }

    /*
     * Check if game is over
     */
    public boolean isGameOver(){
        return  ( (board.isFull())      ||
                  (getWinner() != null)   );
    }


    /*
     * Get the winner of the Game
     */
    public Winner getWinner(){
        if (boardStatus.isBotWinner())
            return Winner.BOT;
        else if(boardStatus.isPlayerWinner())
            return Winner.PLAYER;
        else
            return null;
    }

}
