package cpsc2150.extendedTicTacToe;

public class BoardPosition {// changed extends relation

    private int column;
    private int row;

    /**
     * @invariants BoardPosition initalized by r = row, c = column
     */



    /**
     * constructor to initalize row and column for object BoardPosition
     *
     * @param r = BoardPosition row, c = BoardPosition column
     *
     * @post set the row and column for object calling constructor
     */
    BoardPosition(int r, int c){
        this.row = r;
        this.column = c;
    }



    /**
     * returns the row
     *
     * @post row = #row
     *
     *
     * @return row
     */
    public int getRow(){

        return this.row; //maybe not this

    }


    /**
     * returns the column
     *
     * @post column = #column
     *
     *
     * @return column
     */
    public int getColumn(){

        return this.column;

    }

}
