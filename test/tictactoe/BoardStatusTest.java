package tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardStatusTest {

    /*
     * Tested if Bot win by Column
     */
    @Test
    public void shouldTestIsBotWinner() throws Exception {
        Board board = new Board(3);
        BoardStatus boardStatus = new BoardStatus(board, 2);

        board.setBotMove(1,1);
        board.setHumanMove(1,2);
        board.setBotMove(2,1);
        assertThat(boardStatus.isBotWinner(),is(true));
        assertThat(boardStatus.isPlayerWinner(),is(false));

    }

    /*
     * Tested if Human Winner by Row
     */
    @Test
    public void shouldTestIsPlayerWinner() throws Exception {
        Board board = new Board(3);
        BoardStatus boardStatus = new BoardStatus(board,3);

        board.setHumanMove(1,1);
        board.setHumanMove(1,2);
        assertThat(boardStatus.isPlayerWinner(),is(false));
        assertThat(boardStatus.isBotWinner(),is(false));

        board.setHumanMove(1,3);
        assertThat(boardStatus.isBotWinner(),is(false));
        assertThat(boardStatus.isPlayerWinner(),is(true));

    }

    /*
     * Tested if Human Winner by Bot
     */
    @Test
    public void shouldTestIsPlayerWonByDiagonal() throws Exception {
        Board board = new Board(4);
        BoardStatus boardStatus = new BoardStatus(board,4);

        board.setHumanMove(1,1);
        board.setHumanMove(2,2);
        board.setHumanMove(3,3);

        assertThat(boardStatus.isBotWinner(),is(false));
        assertThat(boardStatus.isPlayerWinner(),is(false));
        board.setHumanMove(4,4);
        assertThat(boardStatus.isPlayerWinner(),is(true));
        assertThat(boardStatus.isBotWinner(),is(false));
    }

    /*
     * Tested if BotWon by Second diagonal
     */
    @Test
    public void shouldTestisBotWonBySecondDiagonal() throws Exception {
        Board board = new Board(4);
        BoardStatus boardStatus = new BoardStatus(board,3);

        board.setHumanMove(4,1);
        board.setBotMove(3,2);
        board.setBotMove(2,3);
        board.setBotMove(1,4);

        assertThat(boardStatus.isBotWinner(),is(true));
        assertThat(boardStatus.isPlayerWinner(),is(false));
    }

}