package main.app;

import java.util.ArrayList;
import java.util.List;

import main.app.menu_options.CalorieMenu;
import main.app.menu_options.IAppOptions;
import main.app.menu_options.RewardMenu;
import main.app.menu_options.StepMenu;

/**
 * This class represent the Menu display.
 *
 */
public class Menu {

  /**
   * This method displays the menu.
   * @param appOptions - the options of the Menu
   */
  public static void displayMenu(List<IAppOptions> appOptions) {

    // Display Menu Options
    System.out.println("M E N U   OPTIONS");
    System.out.println("=================");

    // loop through the options
    for (int i = 0; i < appOptions.size(); i++) {

      IAppOptions option = appOptions.get(i);
      System.out.printf("%d.  %s\n", i + 1, option.getName());

    }

    // Print the Exit Option
    System.out.println("0.  Exit\n");

  }

  public static void main(String[] args) {

    List<IAppOptions> menuOptions = new ArrayList<IAppOptions>();
    IAppOptions calMenu = new CalorieMenu();
    IAppOptions stepMenu = new StepMenu();
    IAppOptions rewardsMenu = new RewardMenu();
    

    // Options Menu data
    menuOptions.add(calMenu);
    menuOptions.add(stepMenu);
    menuOptions.add(rewardsMenu);

    displayMenu(menuOptions);

    int userChoice;
    int exit_int = 0;

    // Create a keyboard object for input validation.
    Keyboard key = new Keyboard();

    userChoice = key.readInteger("Enter choice : ", "Error: Invalid input", exit_int, menuOptions.size());

    // Menu loop.
    while (userChoice != exit_int) {

      // just to demonstrate i saved the choice of the user and can use it to query
      // the db.
      IAppOptions chosenMenuItem = menuOptions.get(userChoice - 1);
      printUserChoice(chosenMenuItem);

      chosenMenuItem.run();

      System.out.println();
      System.out.println();
      

      // Display menu again.
      displayMenu(menuOptions);

      userChoice = key.readInteger("Enter choice : ", "Error: Invalid input", exit_int,
          menuOptions.size());

    }
    System.out.println("GoodBye....");
    System.out.println("...........");

  }

  private static void printUserChoice(IAppOptions option) {
    System.out.printf("Here is the option you chose: %s\n", option.getName());
  }

}
