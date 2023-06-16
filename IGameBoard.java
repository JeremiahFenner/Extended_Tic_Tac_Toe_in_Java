package cpsc2150.extendedTicTacToe;


/**
 *
 * board constaining a 2D array
 * insert a marker at any available position
 *
 */

public interface IGameBoard {



    /**
     * checks pos and returns true if space is avalable false if not
     *
     * @param pos = Board Position
     *
     *
     * @post true iff(board[row][column] != X && board[row][column] != O)
     * @post board = #board
     *          true if board position has a free space
     *
     * @return true if the position specified in pos is available
     *      else return false
     */
    default boolean checkSpace(BoardPosition pos){

        char what = whatsAtPos(pos);

        if(what == 0){//Character.isWhitespace(what)
            return true;
        }else{
            return false;
        }

    }



    /**
     * returns true if the last position played resulted in a win false if not
     *
     * @param lastPos = last Board Position
     *
     * @pre lastPos = column and row of last placed marker
     *
     * @post true iff(checkHorizWin() = true) ||
     *      iff(checkVertWin() = true) ||
     *      iff(checkDiagWin() = true) ||
     *      else false
     *
     *      board = #board
     *
     *
     *
     * @return true if the last play resulted in a win
     *          false if the last play did not result in a win
     */
    default boolean checkForWinner(BoardPosition lastPos){

        char x = whatsAtPos(lastPos);

        if(checkDiagonalWin(lastPos, x) == true){
            return true;
        }else if(checkHorizontalWin(lastPos, x) == true){
            return true;
        }else if(checkVerticalWin(lastPos, x) == true){
            return true;
        }else{
            return false;
        }

    }


    /**
     * returns true if the game resulted in a draw
     *
     * @pre (checkHorizWin() = false) &&
     *      (checkVertWin() = false) &&
     *      (checkDiagWin() = false) &&
     *      CheckForwin() = false
     *
     * @post tie is true when all columns and rows are full and CheckForwin() = false
     *      board = #board
     *
     *
     * @return true if there are no more positions to play and the game
     *         had no true win conditions
     *         else return false
     */
    public boolean checkForDraw();



    /**
     * places the marker at pos marker for char player
     *
     * @param marker = Board Position
     *             char player = current player
     *
     *
     * @pre checkSpace(pos) = true
     *      0 <= column <= 8
     *      0 <= row <= 5
     *      row = #row
     *      column = #column
     *
     *
     * @post places character in marker on the position marker
     *
     *
     */
    public void placeMarker(BoardPosition marker, char player);


    /**
     * returns true if the last position played resulted in a horizontal win false otherwise
     *
     * @param lastPos = last Board Positon
     *                      char player = current player
     *
     * @pre 0 <= row <= 5
     *      0 <= column <= 8
     *      player = 0 or x
     *      lastPos = last placed marker
     *
     *
     * @post true iff(5 sequential horizontal spaces of player)
     *          else false
     *          row = #row
     *          col = #col
     *
     * @return true if  the last marker placed resulted in a 5 in a row horizontally
     *         else return false
     */
    default boolean checkHorizontalWin(BoardPosition lastPos, char player){

        int count = 0;
        int save_col = lastPos.getColumn();
        int save_row = lastPos.getRow();
        int j = lastPos.getColumn();
        int i = lastPos.getRow();
        BoardPosition temp = new BoardPosition(i,j);

        while(player == whatsAtPos(temp) && j > 0){
            count++;
            j--;
            temp = new BoardPosition(i,j);
        }

        if(j == 0 && whatsAtPos(temp) == player) count++;

        temp = new BoardPosition(save_row, save_col);
        j = save_col;


        if(temp.getColumn() != getNumColumns()-1){

            j++;
            temp = new BoardPosition(i,j);


            while(whatsAtPos(temp) == player && j < getNumColumns()-1){

                count++;
                j++;
                temp = new BoardPosition(i,j);
            }

        }

        if(j == getNumColumns()-1 && whatsAtPos(temp) == player) count++;


        if(count == getNumToWin()){
            return true;
        }else{
            return false;
        }


    }


    /**
     * returns true if the last position played resulted in a vertical win false otherwise
     *
     * @param lastPos = last Board Position
     *                      char player = current player
     *
     * @pre 0 <= row <= 5
     *      0 <= column <= 8
     *      player = x or 0
     *      lastPos = last placed marker
     *
     *
     * @post true iff(5 sequential vertical spaces of player)
     *       else false
     *       row = #row
     *       column = #column
     *
     *
     * @return true if the last marker placed resulted in a 5 in a row vertically
     *         else return false
     */
    default boolean checkVerticalWin(BoardPosition lastPos, char player){

        int count = 0;
        int save_row = lastPos.getRow();
        int save_col = lastPos.getColumn();
        int i = lastPos.getRow();
        int j = lastPos.getColumn();
        BoardPosition temp = new BoardPosition(i,j);

        while(player == whatsAtPos(temp) && i > 0){
            count++;
            i--;
            temp = new BoardPosition(i,j);
        }

        if(i == 0 && whatsAtPos(temp) == player) count++;

        temp = new BoardPosition(save_row,save_col);
        i = save_row;


        if(temp.getRow() != getNumRows()-1){

            i++;
            temp = new BoardPosition(i,j);


            while(whatsAtPos(temp) == player && i < getNumRows()-1){

                count++;
                i++;
                temp = new BoardPosition(i,j);
            }

        }

        if(i == getNumRows()-1 && whatsAtPos(temp) == player) count++;

        if(count == getNumToWin()){
            return true;
        }else{
            return false;
        }


    }



    /**
     * returns true if the last position played resulted in a diagonal win false otherwise
     *
     * @param  lastPos = last BoardPosition
     *                      char player = current player
     *
     * @pre 0 <= row <= 5
     *      0 <= column <= 8
     *      player = x or 0
     *      lastPos = last placed marker
     *
     * @post true iff(5 sequential diagonal spaces of player)
     *          else false
     *          row = #row
     *          column = #column
     *
     *
     * @return true if the last marker placed resulted in a 5 in a row diagonally
     *         else return false
     */
    default boolean checkDiagonalWin(BoardPosition lastPos, char player){

        int count = 0;
        int save_row = lastPos.getRow();
        int save_col = lastPos.getColumn();
        int i = lastPos.getRow();
        int j = lastPos.getColumn();
        BoardPosition temp = new BoardPosition(i,j);

        while(player == whatsAtPos(temp) && i > 0 && j > 0){
            count++;
            i--;
            j--;
            temp = new BoardPosition(i,j);
        }

        if((i == 0 || j == 0) && whatsAtPos(temp) == player) count++;

        temp = new BoardPosition(save_row, save_col);
        i = save_row;
        j = save_col;


        if(temp.getRow() != getNumRows()-1 && temp.getColumn() != getNumColumns()-1){

            i++;
            j++;
            temp = new BoardPosition(i,j);


            while(whatsAtPos(temp) == player && i < getNumRows()-1 && j < getNumColumns()-1){

                count++;
                i++;
                j++;
                temp = new BoardPosition(i,j);
            }

        }

        if(count == getNumToWin()){
            return true;
        }else{

            count = 0;
            i = save_row;
            j = save_col;
            temp = new BoardPosition(i,j);

            while(player == whatsAtPos(temp) && i > 0 && j < getNumColumns()-1){
                count++;
                i--;
                j++;
                temp = new BoardPosition(i,j);
            }

            if((i == 0 || j == getNumColumns()-1) && whatsAtPos(temp) == player) count++;

            temp = new BoardPosition(save_row, save_col);
            i = save_row;
            j = save_col;


            if(temp.getRow() != getNumRows()-1 && temp.getColumn() != 0) {

                i++;
                j--;
                temp = new BoardPosition(i, j);


                while (whatsAtPos(temp) == player && i < getNumRows()-1 && j > 0) {

                    count++;
                    i++;
                    j--;
                    temp = new BoardPosition(i, j);
                }

            }

            if(count == getNumToWin()){
                return true;
            }else{
                return false;
            }
        }


    }



    /**
     * returns what char is at position pos, 0 if nothing
     *
     * @param pos = row and column
     *
     * @pre 0 <= row <= 5
     *      0 <= column <= 8
     *
     *
     * @post return marker at position pos or ' ' for empty space
     *      board = #board
     *
     * @return what is in GameBoard at position pos, if no marker return ' '
     */
    public char whatsAtPos(BoardPosition pos);



    /**
     * returns true if player is at position pos in game board
     *
     * @param pos = row and column
     *                      char player = current player
     *
     * @pre 0 <= row <= 5
     *      0 <= column <= 8
     *      player = 0 or x
     *
     * @post true iff(board[pos.row][pos.column] == player)
     *      else false
     *      board = #board
     *
     *
     * @return true if the player is at pos else return false
     */

    public boolean isPlayerAtPos(BoardPosition pos, char player);




    /**
     * returns the number of rows in the game board
     *
     * @post number of Rows = # number of Rows
     *
     *
     * @return number of Rows
     */
    public int getNumRows();


    /**
     * returns the number of columns in game board
     *
     * @post number of columns = # number of columns
     *
     *
     * @return number of columns
     */
    public int getNumColumns();


    /**
     * returns the number in a row to win in game board
     *
     * @post number to win = # number to win
     *
     *
     * @return number to win
     */
    public int getNumToWin();


}


