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

    /*
     * Check if given playerCode is present marks times continuously in a row
     */
    public boolean isWinByRow(Character playerCode){
        int count = 0;
        for (int i = 1 ; i <= board.getSize(); ++i){
            for (int j=1; j <= board.getSize(); ++j){
                Character cellValue = board.getCell(i,j);
                if (count != marks){
                    if ( cellValue == playerCode)
                        ++count;
                    else
                        count = 0;
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
                Character cellValue = board.getCell(j,i);
                if (count != marks){
                    if ( cellValue == playerCode)
                        ++count;
                    else
                        count = 0;
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

//       Consider first Diagonal
        int count = 0;
        for(int i = 1; i <= board.getSize(); ++i){
            if (count != marks){
                if ( playerCode == board.getCell(i,i))
                    ++count;
                else
                    count = 0;
            }
            else
                return true;
        }

//      Consider second diagonal
        count = 0;
        for( int i= board.getSize(); i >0; --i){
            if (count != marks){
                if (playerCode == board.getCell(i,i))
                    ++count;
                else
                    count = 0;
            }
            else
                return true;
        }

        return false;
    }

}
