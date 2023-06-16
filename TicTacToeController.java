package cpsc2150.extendedTicTacToe;
import cpsc2150.extendedTicTacToe.BoardPosition;


/**
 * The TicTacToe controller class will handle communication between our TicTacToeView and our Model (IGameBoard and BoardPosition)
 * <p>
 * This is where you will write code
 * <p>
 * You will need to include your BoardPosition class, the IGameBoard interface
 * and the implementations from previous homeworks
 * If your code was correct you will not need to make any changes to your IGameBoard classes
 */
public class TicTacToeController {

    //our current game that is being played
    private IGameBoard curGame;

    //The screen that provides our view
    private TicTacToeView screen;

    public static final int MAX_PLAYERS = 10;

    private int num_players;

    private char []players = {'X', 'O', 'A', 'B', 'T', 'P', 'E', 'R', 'C', 'L'};
    int q = 0;
    boolean end_game = false;

    /**
     * @param model the board implementation
     * @param view  the screen that is shown
     * @param np    The number of players for the game
     *
     * @post the controller will respond to actions on the view using the model.
     */
    public TicTacToeController(IGameBoard model, TicTacToeView view, int np) {
        this.curGame = model;
        this.screen = view;
        num_players = np;

        // Some code is needed here.
    }

    /**
     * @param row the row of the activated button
     * @param col the column of the activated button
     *
     * @pre row and col are in the bounds of the game represented by the view
     * @post The button pressed will show the right token and check if a player has won.
     */
    public void processButtonClick(int row, int col) {
        // Your code goes here.

        if(end_game == true){ // if the game has completed make a new game
            newGame();
        }

            char player = get_player();
            BoardPosition temp = new BoardPosition(row, col);
            if(curGame.checkSpace(temp) != true){
                screen.setMessage("space is unavailable");
                while(curGame.checkSpace(temp) != true){
                    screen.setMessage("please enter a different row and column");
                    break;
                }
            }else{
                screen.setMarker(row, col, player);
                curGame.placeMarker(temp, player);
                rotate_player(); // rotate player only if checkSpace == true

                if(curGame.checkForWinner(temp) == true){
                    screen.setMessage("you win");
                    end_game = true;
                }
                if(curGame.checkForDraw() == true){
                    screen.setMessage("you tie");
                    end_game = true;
                }
            }



    }

    private void newGame() {
        // You do not need to make any changes to this code.
        screen.dispose();
        GameSetupScreen screen = new GameSetupScreen();
        GameSetupController controller = new GameSetupController(screen);
        screen.registerObserver(controller);
    }


    /**
     * this function increments the counter q to the next player
     *
     * @pre q >= 0 && q <= 10
     *
     * @post q + 1 or if q = num_players q = 0
     */
    public void rotate_player(){
        if(q >= (num_players-1)){
            q = 0;
        }else{ q++;}
    }

    /**
     * this functions returns the char of the current player
     *
     * @return char of the current player
     */
    public char get_player(){
        return players[q];
    }
}
