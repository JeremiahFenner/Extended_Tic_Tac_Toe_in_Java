package cpsc2150.extendedTicTacToe;

public class GameBoard extends AbsGameBoard implements IGameBoard {

    private int num_row;
    private int num_col;
    private int num_win;
    private char[][] board = new char[num_row][num_col];





    /**
     *
     * @invariants board must be of size 4x4 to 20x20
     * @invariants there should not be any space between board positions
     *
     *
     *
     */

    /**
     *
     * @pre row must be between 4 and 20 inclusive
     * column must be between 4 and 20 inclusive
     * w must be > 2 && < rows and columns and < 25
     *
     * @post initial state of gameBoard is empty two dimensional char array
     * @post create new two dimensional character array
     *  of size 5 x 8
     *
     */
    public GameBoard(int r, int c, int w){
        num_win = w;
        num_row = r;
        num_col = c;

        board = new char[num_row][num_col];

        for(int i = 0; i < num_row; i++){
            for(int j = 0; j < num_col; j++){
                board[i][j] = 0;
            }
        }

    }



    public boolean checkForDraw(){
        int count = 0;
        for(int i = 0; i < num_row; i++){
            for(int j = 0; j < num_col; j++){
                if(board[i][j] != 0) count++;
            }
        }
        if(count == (num_row * num_col)){
            return true;
        }else{ return false; }
    }



    public void placeMarker(BoardPosition marker, char player){

        board[marker.getRow()][marker.getColumn()] = player;

    }




    public boolean isPlayerAtPos(BoardPosition pos, char player){

        int i = pos.getRow();
        int j = pos.getColumn();

        char x = board[i][j]; // could call whats at pos

        if(x == player){
            return true;
        }else{
            return false;
        }
    }

    public int getNumRows(){return num_row;}

    public int getNumColumns(){return num_col;}

    public int getNumToWin(){return num_win;}



    public char whatsAtPos(BoardPosition pos){
        return board[(pos.getRow())][(pos.getColumn())];
    }




}
