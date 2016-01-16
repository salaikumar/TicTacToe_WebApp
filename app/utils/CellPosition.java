package utils;

public class CellPosition {

    private final int  row;
    private final int  col;

    public CellPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    @Override
    public int hashCode(){
        return row ^ col;
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof CellPosition))
            return false;
        CellPosition obj = (CellPosition) o;
        return ( (obj.getCol() == this.col) &&
                 (obj.getRow() == this.row)   );
    }

}
