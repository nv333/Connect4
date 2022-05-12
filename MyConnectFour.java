/**
* This MyConnectFour class contains the logic for the game.
* It uses the Board and Payer classes and creates objects of them here to be used in the actual playing of the game.
*/
public class MyConnectFour {

  // Creates local variables from Board and Player classes.
  private Board board; 
  private Player player1;
  private Player player2;
  
  // Main method which is executed 
  public static void main(String[] args) {
    new MyConnectFour();
  }
  
  // Constructor initialises new objects
  public MyConnectFour() {
    board = new Board();
    player1 = new Player("r");
    player2 = new Player("y");
  }

  /** 
  * Method which contains the game logic and is called in Main
  * Takes input from player one, places counter to the board, if space in the column.
  * If no win is found, repeats for player 2.
  */
  public void playGame() {
    System.out.println("Welcome to Connect 4!");
    System.out.println("There are 2 players:");
    System.out.println("Player 1 is red, Player 2 is yellow.");
    System.out.println("To play the game, type in the number of the column you want to drop you counter in.");
    System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally.");
    System.out.println("");
    String bs = board.getBoardString();
    System.out.println(bs);

    while (!board.hasWon()) {

      // Player 1 input
      int userInput = 0;
      Player player = player1;
      userInput = player.validInput(); 

      // Check for space in column, if yes, place counter
      boolean stillSpace = board.placeCounter('r', userInput);
      if (stillSpace == true){
        //
      }
      else{
        System.out.println("Column is full.");
        continue;
      }
      
      // Print board with counter(s), check for win
      System.out.println(board.getBoardString());
      board.playerWin('r');
      if (board.hasWon()) {
        //
      } else {
        
        // Computer play 
        player = player2;

        // Check for space in column, if yes, place counter
        do{
          stillSpace = board.placeCounter('y', player.getComputerInput());
        }
        while (!stillSpace);

        // Print board with counter(s), check for win
        board.playerWin('y');
        System.out.println(board.getBoardString());
        
      }
    } 
  }
}