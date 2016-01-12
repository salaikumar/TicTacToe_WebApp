package tictactoe;

import org.junit.Test;

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
}