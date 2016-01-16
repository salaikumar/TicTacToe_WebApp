package utils;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CellPositionTest {

    @Test
    public void shouldTestCellPositionUtil(){
        CellPosition cellPosition = new CellPosition(2,3);
        assertThat(cellPosition.getCol(),is(3));
        assertThat(cellPosition.getRow(),is(2));
    }

    @Test
    public void shouldTestHasCodeAndEquals(){
        CellPosition cellPosition1 = new CellPosition(2,1);
        CellPosition cellPosition2 = new CellPosition(2,2);
        CellPosition cellPosition3 = new CellPosition(2,2);
        assertThat(cellPosition1.equals(cellPosition1),is(true));
        assertThat(cellPosition1.equals(cellPosition2),is(false));
        assertThat(cellPosition2.equals(cellPosition3),is(true));
        assertTrue(cellPosition1.hashCode() !=cellPosition2.hashCode());
        assertTrue(cellPosition2.hashCode() ==cellPosition3.hashCode());
    }
}