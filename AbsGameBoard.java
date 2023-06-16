package cpsc2150.extendedTicTacToe;

public abstract class AbsGameBoard implements IGameBoard {


    /**
     *  prints game board as string
     *
     * @post prints game board returned as string;
     *   game board = #gameboard
     */

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("   ");

        for (int i = 0; i < getNumColumns(); i++) {
            if(i < 10){
                result.append(" " + i + "|");
            }else{
                result.append(i + "|");
            }
        }
        result.append("\n");
        for (int x = 0; x < getNumRows(); x++) {
            for (int y = 0; y < getNumColumns(); y++) {
                BoardPosition temp = new BoardPosition(x,y);
                if (y == 0) {
                    if(x < 10){
                        result.append(" ");
                        result.append(x);
                    }else{
                        result.append(x);
                    }
                    if (whatsAtPos(temp) == 0) {
                        result.append("|");
                        result.append("  ");
                        result.append("|");
                    } else {
                        result.append("| ");
                        result.append(whatsAtPos(temp));
                        result.append("|");
                    }
                } else if (y == (getNumColumns()-1)) {
                    if (whatsAtPos(temp) == 0) {
                        result.append("  ");
                        result.append("|\n");
                    } else {
                        result.append(" ");
                        result.append(whatsAtPos(temp));
                        result.append("|\n");
                    }
                } else {
                    if (whatsAtPos(temp) == 0) {
                        result.append("  ");
                        result.append("|");
                    } else {
                        result.append(" ");
                        result.append(whatsAtPos(temp));
                        result.append("|");
                    }
                }
            }
        }

        return result.toString();
    }

    /**
     *  overloads equals to compare board positions
     *
     * @post returns true if pos1 and pos2 are equal
     *      false if not
     */
    public boolean equals(BoardPosition pos1, BoardPosition pos2){
        if(pos1.getRow() == pos2.getRow() && pos1.getColumn() == pos2.getColumn()){
            return true;
        }else { return false; }
    }
}

