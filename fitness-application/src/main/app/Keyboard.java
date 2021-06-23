package main.app;

import java.util.Scanner;

/**
 * This class is for user Input validation.
 *
 */
public class Keyboard {

  private Scanner in;

  Keyboard() {
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
      System.out.println(promptMsg);

      // Grab input from keyboard
      inputString = in.nextLine();

      // try to convert String to int.
      try {
        validNumber = Integer.parseInt(inputString);
        if (validNumber >= low && validNumber <= high)
          valid = true;
        else
          System.out.println(errorMsg);

      } catch (NumberFormatException e) {

        System.out.println(errorMsg);

      }

    }

    return validNumber;

  }

}
