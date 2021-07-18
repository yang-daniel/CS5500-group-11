package main.app;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class is for user Input validation.
 *
 */
public class Keyboard {

  private static Logger LOGGER = LogManager.getLogger(Keyboard.class.getName());

  private Scanner in;

  public Keyboard() {
    in = new Scanner(System.in);
  }

  /**
   * This method validate an integer.
   * 
   * @param promptMsg --- a prompt message to display to the user.
   * @param errorMsg  --- an error message to display if error occur.
   * @param low       --- a minimum possible number.
   * @param high      --- maximum possible number.
   * @return a validated number.
   */
  public int readInteger(String promptMsg, String errorMsg, int low, int high) {

    int validNumber = 0;
    String inputString;
    boolean valid = false;

    // keep looking until valid input
    while (valid == false) {
      // prompt the user
      LOGGER.info(promptMsg);

      // Grab input from keyboard
      inputString = in.nextLine();

      // try to convert String to int.
      try {
        validNumber = Integer.parseInt(inputString);
        if (validNumber >= low && validNumber <= high)
          valid = true;
        else
          LOGGER.error(errorMsg);

      } catch (NumberFormatException e) {

        LOGGER.error(errorMsg);

      }

    }

    return validNumber;

  }

}
