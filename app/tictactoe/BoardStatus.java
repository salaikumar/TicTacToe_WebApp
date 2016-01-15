package tictactoe;

import play.api.mvc.BodyParser;
import scala.Char;

/**
 * Board Status
 * Helps to determine the state of Board whenever required
 */
public class BoardStatus {

    private final Board board;
    private int marks;

    public BoardStatus(Board board,int marks){
        this.board = board;
        this.marks = marks;
    }

    public BoardStatus(BoardStatus boardStatus){
        this.board = boardStatus.board;
        this.marks = boardStatus.marks;
    }


    public boolean isPlayerWinner() {
        return isWinByColumn(Board.humanCode) ||
                isWinByColumn(Board.humanCode) ||
                isWinByDiagonal(Board.humanCode);
    }

    public boolean isBotWinner() {
        return isWinByColumn(Board.botCode) ||
                isWinByColumn(Board.botCode) ||
                isWinByDiagonal(Board.botCode);
    }
    
    public boolean isWinByRow(Character playerCode){
        return false;
    }

    public boolean isWinByColumn(Character playerCode){
        return false;
    }

    public boolean isWinByDiagonal(Character playerCode){
        return false;
    }

}
