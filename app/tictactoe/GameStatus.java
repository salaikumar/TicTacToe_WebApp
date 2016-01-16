package tictactoe;


import utils.Winner;

/*
 * Game Status
 * Class is used to display the result at each step of game
 */
public class GameStatus {

    private String message;
    private Winner winner;
    private int    winMoves;
    private String status;
    private String board;
    private boolean isGameOver;

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public void setWinMoves(int winMoves) {
        this.winMoves = winMoves;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setIsGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();

        output.append("Message:" + message);
        output.append(System.lineSeparator());

        output.append("isGameOver:" + isGameOver);
        output.append(System.lineSeparator());

        output.append("Status:" + status);
        output.append(System.lineSeparator());

        output.append("marks:" + winMoves);
        output.append(System.lineSeparator());

        output.append("Winner:" + winner);
        output.append(System.lineSeparator());

        output.append("Board:" +board);
        output.append(System.lineSeparator());

        return new String(output);
    }
}
