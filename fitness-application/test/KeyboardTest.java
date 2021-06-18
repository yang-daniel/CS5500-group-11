import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Scanner;

/**
 * A JUnit test class for the Keyboard class.
 * @author THE PRINCE
 *
 */
public class KeyboardTest {

  
  private String promptMsg = "Input message" ;
  private String errorMsg = "Error message"; 
  private int low = 5;
  private int high = 12;
  
  Keyboard key = new Keyboard();
  
  
  
  /**
   * A test that readInteger works correctly.
   * 
   */
  @Test
  public void testReadInteger() {
    
    Scanner in = new Scanner ( "6" );
    int expectedValue =  Integer.parseInt(in.nextLine());
    int userChoice = key.readInteger(promptMsg, errorMsg, low,high);
    
   
  
    //TODO ---> works if I enter 6, how to automate it?
    
    //compare the userChoice and expectedValue.
    //assertEquals(userChoice, expectedValue); 
    
    //compare the userchoice and the toString
    // assertEquals(userChoice, key.toString()); 
    
    //Compare the expected value and the toString
    assertEquals(expectedValue, key.toString());
    
    
  }

}
