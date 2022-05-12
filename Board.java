// Reference for playerWin: https://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm
// Board class
public class Board{

  // Creates local variables
  private char[][] board;
  private boolean win;

  // Board constructor instantiates variables
  // board variable accepts arguments meaning size is not fixed
  public Board(){
    board = new char[6][7];
    win = false;
  }

  /**
  * Takes position from player and places a counter onto the board
  * i = rows, j = columns
  * @param char from player input   'r' or 'y'
  * @param position    int from 1 to 7 corresponding to columns
  * @return placed   position of added counter on board
  */
  public boolean placeCounter(char player, int position) {
    boolean placed = false;
    if (player == 'r') {
      for (int i = board.length - 1; i >= 0; i--) {
        if (!placed) {
          if (board[i][position - 1] == 'y') {
            // skip
          } else if (board[i][position - 1] != 'r') {
            board[i][position - 1] = 'r';
            placed = true;
          }
        }
      }
    } else {
      for (int i = board.length - 1; i >= 0; i--) {
        if (!placed) {
          if (board[i][position - 1] == 'r') {
            // skip
          } else if (board[i][position - 1] != 'y') {
            board[i][position - 1] = 'y';
            placed = true;
          }
        }
      }
    }
    return placed;
  }
  
  /**
  * Checks board for four in a row from either player
  * @param char counter colour    'r' or 'y'
  * @return hasWon boolean    depending on whether have won or not
  */
  public boolean playerWin(char colour){
    boolean hasWon = false;
    // player 1 check horizontal
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length-3; j++) {
        if (board[i][j] == 'r' && board[i][j+1] == 'r' && board[i][j+2] == 'r' && board[i][j+3] == 'r') {
          hasWon = true;
          System.out.println("You have won horizontally!\n");
        }
      }
    }
    // player 1 check vertical
    for (int i = 0; i < board.length-3; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 'r' && board[i+1][j] == 'r' && board[i+2][j] == 'r' && board[i+3][j] == 'r') {
            hasWon = true;
            System.out.println("You have won vertically!\n");
        }
      }
    }
    // player 1 check ascending diagonal /
    for (int i = 3; i < board.length; i++) {
      for (int j = 0; j < 7-3; j++) {
        if (board[i][j] == 'r' && board[i-1][j+1] == 'r' && board[i-2][j+2] == 'r' && board[i-3][j+3] == 'r') {
          hasWon = true;
          System.out.println("You have won diagonally!\n");
        }
      }      
    }
    // player 1 check descending diagonal \
    for (int i=3; i<board.length; i++){
      for (int j=3; j<7; j++){
        if (board[i][j] == 'r' && board[i-1][j-1] == 'r'&& board[i-2][j-2] == 'r' && board[i-3][j-3] == 'r'){
          hasWon = true;
          System.out.print("You have won diagonally!\n");
        }
      }
    }
    //player 2 check horizontal
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length-3; j++) {
        if (board[i][j] == 'y' && board[i][j+1] == 'y' && board[i][j+2] == 'y' && board[i][j+3] == 'y') {
          hasWon = true;
          System.out.println("Player 2 has won horizontally.\n");
        }
      }
    }
    //player 2 check vertical
    for (int i = 0; i < board.length-3; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 'y' && board[i+1][j] == 'y' && board[i+2][j] == 'y' && board[i+3][j] == 'y') {
          hasWon = true;
          System.out.println("Player 2 has won vertically.\n");
        }
      }
    }
    //player 2 check descending diagonal
    for (int i=3; i<board.length; i++){
      for (int j=3; j<7; j++){
        if (board[i][j] == 'y' && board[i-1][j-1] == 'y'&& board[i-2][j-2] == 'y'&& board[i-3][j-3] == 'y'){
          hasWon = true;
          System.out.print("Player 2 has won diagonally.\n");
        }
      }
    }
    //player 2 check ascending diagonal
    for (int i=3; i<board.length; i++){
      for (int j=0; j<7-3; j++){
        if (board[i][j] == 'y' && board[i-1][j+1] == 'y' && board[i-2][j+2] == 'y'&& board[i-3][j+3] == 'y'){
          hasWon = true;
          System.out.print("Player 2 has won diagonally.\n");
        }
      }
    }
    return hasWon;
  } 

  /**
  * Checks whether there has been a win on the board
  * @return win    sets condition to win and ends game
  */
  public boolean hasWon(){
    return win;
  }

  /**
  * Creates a printable board to display to user
  * Return type of String encapsulates functionality, rather than simply printing board
  * @return string board    used to print board with updated counter additions to console
  */
  public String getBoardString(){
    String sBoard = "";
    sBoard += ("  1   2   3   4   5   6   7\n");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'r') {
          sBoard += ("| r ");
        } else if (board[i][j] == 'y') {
          sBoard += ("| y ");
        } else {
          sBoard += ("|   ");
        }
      }
      sBoard += ("|\n");
    }
    sBoard += ("  1   2   3   4   5   6   7\n");
    return sBoard;
  }
}