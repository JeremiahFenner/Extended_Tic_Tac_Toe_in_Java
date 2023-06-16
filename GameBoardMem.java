package cpsc2150.extendedTicTacToe;
import java.util.*;

public class GameBoardMem extends AbsGameBoard implements IGameBoard{

    List<BoardPosition> lst = new ArrayList<BoardPosition>();
    private Map<Character, List<BoardPosition>> board = new HashMap<>();
    private int num_row;
    private int num_col;
    private int num_win;

    public GameBoardMem(int r, int c, int w){
        lst = new ArrayList<>();
        board = new HashMap<Character, List<BoardPosition>>();
        num_row = r;
        num_col = c;
        num_win = w;
    }


    public char whatsAtPos (BoardPosition pos){
        Set<Character> setOfKeySet = board.keySet();
        for(Character key : setOfKeySet){
            for(BoardPosition place : board.get(key)){
                if(equals(place, pos) == true) {  return key; }
            }
        }
        return 0;
    }

    public boolean isPlayerAtPos(BoardPosition pos, char player){
        for(BoardPosition place : board.get(player)){
            if(equals(place, pos) == true){ return true; }
        }
        return false;
    }


    public boolean checkForDraw() {
        int count = 0;
        Set<Character> setOfKeySet = board.keySet();
        for (Character key : setOfKeySet) {
            for (BoardPosition place : board.get(key)) {
                count++;
            }
        }
        if(count == (num_row * num_col)){
            return true;
        }else{ return false; }
    }

    public int getNumRows(){ return num_row; }

    public int getNumColumns(){ return num_col; }

    public int getNumToWin(){ return num_win; }

    public void placeMarker(BoardPosition marker, char player){
        List<BoardPosition> mylst = new ArrayList<>();
        if(board.get(player) == null){
            board.put(player, mylst);
            board.get(player).add(marker);
        }else{ board.get(player).add(marker); }
    }




}
