package main.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.app.menu_options.CalorieMenu;
import main.app.menu_options.AAppOptions;
import main.app.menu_options.ActivityMenu;
import main.app.menu_options.RewardMenu;
import main.app.menu_options.StepMenu;
import main.client.IMongoDBClient;
import main.client.MongoDBClient;

/**
 * This class represent the Menu display.
 *
 */
public class Menu {

  private static Logger LOGGER = LogManager.getLogger(Menu.class.getName());


  public static void main(String[] args) {

    LOGGER.info("test");
    
    IMongoDBClient client = new MongoDBClient();
    boolean connSuccess = client.setup();

    if (!connSuccess) {
      LOGGER.error("Unable to connect to the database. Please try again later.");
      return;
    }

    List<AAppOptions> menuOptions = new ArrayList<AAppOptions>();
    AAppOptions calMenu = new CalorieMenu(client);
    AAppOptions stepMenu = new StepMenu(client);
    AAppOptions rewardsMenu = new RewardMenu(client);
    AAppOptions activitiesMenu = new ActivityMenu(client);

    

    // Options Menu data
    menuOptions.add(calMenu);
    menuOptions.add(stepMenu);
    menuOptions.add(rewardsMenu);
    menuOptions.add(activitiesMenu);

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
      AAppOptions chosenMenuItem = menuOptions.get(userChoice - 1);
      printUserChoice(chosenMenuItem);

      chosenMenuItem.run();

      System.out.println();
      System.out.println();
      

      // Display menu again.
      displayMenu(menuOptions);

      userChoice = key.readInteger("Enter choice : ", "Error: Invalid input", exit_int,
          menuOptions.size());

    }
    LOGGER.info("\nGoodBye....\n...........");

  }


  /**
   * This method displays the menu.
   * @param appOptions - the options of the Menu
   */
  private static void displayMenu(List<AAppOptions> appOptions) {

    // Display Menu Options
    System.out.println("M E N U   OPTIONS");
    System.out.println("=================");

    // loop through the options
    for (int i = 0; i < appOptions.size(); i++) {

      AAppOptions option = appOptions.get(i);
      System.out.printf("%d.  %s\n", i + 1, option.getName());

    }

    // Print the Exit Option
    System.out.println("0.  Exit\n");

  }

  private static void printUserChoice(AAppOptions option) {
    System.out.printf("Here is the option you chose: %s\n", option.getName());
    System.out.println();
  }

}
