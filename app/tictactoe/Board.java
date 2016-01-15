package tictactoe;

import play.api.mvc.ActionRefiner;

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
    private Integer freeCells;

    public Board(Integer size){
        this.size = size;
        cell = new Character[size][size];
        freeCells = size * size;
    }

//  Copy Constructor.
    public Board(Board board){
        this.size = board.getSize();
        this.freeCells = board.freeCells;
        this.cell = new Character[board.getSize()][board.getSize()];
        for (int i = 0; i < board.getSize(); ++i)
            System.arraycopy(board.cell[i], 0, this.cell[i], 0, board.getSize());
    }

    public Integer getSize(){
        return size;
    }

    public boolean isFree(Integer row, Integer column){
        return cell[row-1][column-1] == null;
    }

    public boolean setBotMove(Integer row, Integer col) throws Exception {
        checkValidPosition(row,col);
        cell[row-1][col-1] = botCode;
        --freeCells;
        return true;
    }

    public boolean setHumanMove(Integer row,Integer col) throws Exception {
        checkValidPosition(row,col);
        cell[row-1][col-1] = humanCode;
        --freeCells;
        return true;
    }

    private void checkValidPosition(Integer row, Integer col) throws Exception {
        if ( row < 1 || col < 1)
            throw new IndexOutOfBoundsException("Row or Column is invalid");

        if (row > size || col > size)
            throw new IndexOutOfBoundsException("Row or Column is invalid");

        if ( ! isFree(row,col))
            throw new Exception("Cell already taken");
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

        output.append(horizontalLine);
        output.append(System.lineSeparator());

        for (int i=0; i < size; ++i){
            for (int j= 0; j < size; ++j){
                output.append(cell[i][j] + verticalPadding);
            }
            output.append(System.lineSeparator());
            output.append(horizontalLine);
            output.append(System.lineSeparator());
        }
        return new String(output);

    }

//  How efficient is this HASH method?
//  if Board is empty, chances of unique values possible.
    public int hashCode(){
        return size * Arrays.deepHashCode(this.cell);
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
        if ( !Arrays.deepEquals( this.cell, givenObject.cell))
            return false;
        return true;
    }

    public boolean isFull(){
        return freeCells == 0;
    }

}
