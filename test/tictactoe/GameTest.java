package tictactoe;

import javafx.scene.control.Cell;
import org.hibernate.validator.internal.metadata.raw.ConstrainedElement;
import org.junit.Test;
import utils.CellPosition;
import utils.Winner;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class GameTest {

    /*
     * 1. Fill a empty cell
     * 2. Fill a non Empty Cell
     */
    @Test
    public void  shouldTestMoves(){
        Game game = new Game(3,2);
        game.humanMove("1|1");
        assertThat(game.getBoard().getCell(1,1),is(Board.humanCode));
        assertThat(game.botMove(new CellPosition(1,1)),is(false));
        game.botMove(new CellPosition(2,2));
        assertThat(game.getBoard().getCell(2,2),is(Board.botCode));
        assertThat(game.botMove(new CellPosition(2,2)),is(false));
    }


    /*
     * Test isOver and getWinner
     */
    @Test
    public void shouldTestIsOverAndGetWinner(){
        Game game = new Game(3,2);
        game.botMove(new CellPosition(1,1));
        game.humanMove("1|2");
        assertThat(game.isGameOver(),is(false));
        assertThat(game.getWinner(),is(nullValue()));
        game.botMove(new CellPosition(2,1));
        assertThat(game.isGameOver(),is(true));
        assertThat(game.getWinner(),is(Winner.BOT));
    }

    /*
     * getFreePosition  Test Case
     */
    @Test
    public void shouldTestGetFreePosition(){
        Game game = new Game(3,2);
        game.botMove(new CellPosition(2,3));
        CellPosition cellPosition = game.freePosition();
        assertThat(game.getBoard().isFree(cellPosition.getRow(),cellPosition.getCol()),is(true));
        CellPosition cellPosition1 = new CellPosition(2,3);
        assertThat(game.getBoard().isFree(cellPosition1.getRow(),cellPosition1.getCol()),is(false));

    }
}