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
        return isWinByRow(Board.humanCode) ||
                isWinByColumn(Board.humanCode) ||
                isWinByDiagonal(Board.humanCode);
    }

    public boolean isBotWinner() {
        return isWinByRow(Board.botCode) ||
                isWinByColumn(Board.botCode) ||
                isWinByDiagonal(Board.botCode);
    }

    /*
     * Check if given playerCode is present marks times continuously in a row
     */
    public boolean isWinByRow(Character playerCode){
        int count = 0;
        for (int i = 1 ; i <= board.getSize(); ++i){
            for (int j=1; j <= board.getSize(); ++j){
                Character cellValue = board.getCell(i,j);
                if (count != marks){
                   count = calculateCount(i,j,count,playerCode);
                }
                else
                    break;
            }
            if (count == marks)
                return true;
        }
        return false;
    }

    public boolean isWinByColumn(Character playerCode){
        int count = 0;
        for (int i = 1 ; i <= board.getSize(); ++i){
            for (int j=1; j <= board.getSize(); ++j){
                if (count != marks){
                    count = calculateCount(j,i,count,playerCode);
                }
                else
                    break;
            }
            if (count == marks)
                return true;
        }
        return false;
    }

    public boolean isWinByDiagonal(Character playerCode){
        return isWinbyFirstDiagonal(playerCode) || isWinBySecondDiagonal(playerCode);
    }

    private int calculateCount(int position, int count, Character playerCode){
        if (playerCode == board.getCell(position,position))
            return  ++count;
        return 0;
    }

    private int calculateCount( int row,int col,int count, Character playerCode){
        if ( board.getCell(row,col) == playerCode)
            return ++count;
        return 0;
    }

    private boolean isWinbyFirstDiagonal(Character playerCode){
        int count = 0;
        for(int i = 1; i <= board.getSize(); ++i){
            if (count != marks)
                count =  calculateCount(i,count,playerCode);
        }
        return count == marks;
    }

    private boolean isWinBySecondDiagonal(Character playerCode){
        int  count = 0;
        for (int i = board.getSize(), j = 1; i > 0 && j <= board.getSize(); --i,++j){
            if (count != marks)
                count = calculateCount(i,j,count,playerCode);
        }
        return count == marks;
    }

    public int getMarks() {
        return marks;
    }
}
