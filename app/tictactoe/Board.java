package tictactoe;

import play.api.mvc.MultipartFormData;
import scala.Char;

import java.util.Arrays;

/**
 * Board
 * Size as defined by the user
 */

public class Board {

    private Integer size;
    private Character[][] cell;
    private final Character botCode = 'X';
    private final Character humanCode = 'O';

    public Board(Integer size){
        this.size = size;
        cell = new Character[size][size];
    }

    public Integer getSize(){
        return size;
    }

    public void setBotMove(Integer row, Integer col){
        cell[row-1][col-1] = botCode;
    }

    public void setHumanMove(Integer row,Integer col){
        cell[row-1][col-1] = humanCode;
    }

    public Character getCell(Integer row, Integer col){
        return cell[row-1][col-1];
    }

    public Character[][] getAllCells(){
        return cell;
    }

    /*
     * --------------
     * X | O | X |
     * X | X | O |
     * O | O | X |
     * --------------
     */
    public String toString(){
        String horizontalLine = "---------------";
        String verticalPadding = "|";
        StringBuilder output = new StringBuilder();

        output.append(horizontalLine+"\n");

        for (int i=0; i < size; ++i){
            for (int j= 0; j < size; ++j){
                output.append(cell[i][j] + verticalPadding);
            }
            output.append("\n");
        }

        output.append(horizontalLine);

        return new String(output);

    }

    public int hashCode(){
        return 0;
    }

    public boolean equals(Object obj){

        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Board givenObject = (Board) obj;

        if (this.size != givenObject.size)
            return false;

//      Do I need a deeEquals?
        if ( !Arrays.equals( this.cell, givenObject.cell))
            return false;

        return true;
    }

}
