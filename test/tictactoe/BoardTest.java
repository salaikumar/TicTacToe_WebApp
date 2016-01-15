package tictactoe;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import play.api.mvc.BodyParser;
import play.api.mvc.MultipartFormData;

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
        board.setBotMove(1,1);
        assertThat(board.getCell(1,1),is('X'));

        board.setHumanMove(1,2);
        assertThat(board.getCell(1,2),is('O'));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsFreeViaException() throws Exception {
        Board board = new Board(3);
        board.setHumanMove(-5,1);
    }

    @Test(expected = Exception.class)
    public void testIsFreeViaMove() throws Exception {
        Board board = new Board(3);
        board.setBotMove(2,2);
        assertThat(board.setHumanMove(2,2),is(false));
    }

    @Test
    public void shouldTestToString() throws Exception {
        Board board = new Board(3);

//      Fill the Diagonal
        board.setBotMove(1,1);
        board.setBotMove(2,1);
        board.setBotMove(3,1);

//      Fill some position for Human
        board.setHumanMove(1,2);
        board.setHumanMove(2,2);
        board.setHumanMove(3,2);

        String horizontalLine = "---------------";
        String verticalPadding = "|";
        StringBuilder output = new StringBuilder();

        output.append(horizontalLine);
        output.append(System.lineSeparator());
        output.append('X' + "|");
        output.append('O' + "|");
        output.append(null + "|");
        output.append(System.lineSeparator());
        output.append(horizontalLine);
        output.append(System.lineSeparator());

        output.append('X' + "|");
        output.append('O' + "|");
        output.append(null + "|");
        output.append(System.lineSeparator());
        output.append(horizontalLine);
        output.append(System.lineSeparator());

        output.append('X' + "|");
        output.append('O' + "|");
        output.append(null+ "|");
        output.append(System.lineSeparator());
        output.append(horizontalLine);
        output.append(System.lineSeparator());

        assertThat(board.toString(),is(output.toString()));
    }

    @Test
    public void shouldTestIsFull() throws Exception {
        Board board = new Board(3);

        board.setBotMove(1,1);
        board.setBotMove(2,1);
        board.setBotMove(3,1);

        board.setHumanMove(1,2);
        board.setHumanMove(2,2);
        board.setHumanMove(3,2);

        assertThat(board.isFull(),is(false));

        board.setHumanMove(1,3);
        board.setHumanMove(2,3);
        board.setHumanMove(3,3);

        assertThat(board.isFull(),is(true   ));
    }

    /*
     * Testing is performed for 3 properties
     * Reflexive, Symmetric, Transitive
     *
     */
    @Test
    public void shouldTestEqualsAndHashCode(){
        Board board1 = new Board(3);
        Board board2 = new Board(6);

        assertThat(board1.equals(board2),is(false));
        assertTrue(board1.hashCode() != board2.hashCode());

    }

    /*
     * Reflexive,Symmetric using Equals and HashCode
     */
    @Test
    public void shouldTestReflexive() throws Exception {
        Board board1 = new Board(3);
        Board board2 = new Board(3);
        assertThat(board1.equals(board1),is(true));
        assertThat(board1.hashCode(),is(board2.hashCode()));

        board2.setBotMove(1,2);
        assertThat(board1.equals(board2),is(false));
        assertTrue(board1.hashCode() != board2.hashCode() );
//        assertTrue(board1.hashCode() == board2.hashCode() );
    }

    @Test
    public void shouldTestTransitive() throws Exception {
        Board a = new Board(3);
        Board b = new Board(3);
        Board c = new Board(3);

        a.setBotMove(1,1);
        b.setBotMove(1,1);
        c.setBotMove(1,1);

        assertThat(a.equals(b),is(true));
        assertThat(b.equals(c),is(true));
        assertThat(a.equals(c),is(true));
        c.setHumanMove(2,1);
        assertThat(a.equals(c),is(false));
    }

    @Test
    public void shouldTestCopyConstructor() throws Exception {
        Board board = new Board(3);
        board.setBotMove(1,1);
        Board board2 = new Board(board);
        assertThat(board.equals(board2),is(true));
        board2.setBotMove(2,1);
        assertThat(board.equals(board2),is(false));
    }
}