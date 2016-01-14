package tictactoe;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *  Test cases for Board Class
 */
public class BoardTest {

    @Test
    public void testInstanceCreation(){
        Board board = new Board(3);
        assertThat(board.getSize(), is(3));
    }

    @Test
    public void shouldTestMoves() throws Exception {
        Board board = new Board(3);

//      Make my move at 0,0,.
        board.setBotMove(1,1);
        assertThat(board.getCell(1,1),is('X'));

//      Make his move at 0,0
        board.setHumanMove(1,2);
        assertThat(board.getCell(1,2),is('O'));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsFreeViaException() throws Exception {
        Board board = new Board(3);
        board.setHumanMove(-5,1);
    }
}