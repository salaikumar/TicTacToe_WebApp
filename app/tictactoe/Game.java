package tictactoe;


import utils.CellPosition;

import java.util.regex.Pattern;

public class Game {
    
    private Board board;
    private BoardStatus boardStatus;


    /*
     * Constructor
     * Copy Constructor is not required by now.
     */
    public Game(int size, int marks){
        board = new Board(size);
        boardStatus = new BoardStatus(board, marks);
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
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
