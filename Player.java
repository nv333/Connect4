// Package including input and output streams
import java.io.*;

/**
* Player class includes input stream reader to take player input.
* If move is legal, returns to MyConnectFour class.
* Gets random input for computer play.
*/
public class Player{

  // Private variables
  private String counter;
  private BufferedReader input;

  // Constructor initialises variables
  public Player(String counter){
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  /**
  * Get input from user
  * @return integer   intended player position
  */
  public int getUserInput(){
    String stringInput = null;
    int intInput = 0;
    try{    
      stringInput = input.readLine();
      intInput = Integer.parseInt(stringInput);
    }
    catch (ArrayIndexOutOfBoundsException | IOException | NumberFormatException  e){
    }
    return intInput;
  }

  /**
  * Checks if input from player is legel: fits on board or is a number
  * @return integer   legal position
  */
  public int validInput(){
    boolean isValid = false;
    int input = 0;
      do{
        input = getUserInput();
        if (input > 0 && input <=7){
          isValid = true;
        }
        else {
          System.out.println("Enter a number from 1 to 7.");
        }
      }
      while (!isValid);
    return input;
  }

  /**
  * Get random integer for computer play
  * @return integer   position to be placed on board
  */
  public int getComputerInput(){
    int min = 1;
    int max = 7;
        
    int randomInput = (int)Math.floor(Math.random()*(max-min+1)+min);
    System.out.println("Player 2 played: " + randomInput + "\n");
    return randomInput;
  }
}