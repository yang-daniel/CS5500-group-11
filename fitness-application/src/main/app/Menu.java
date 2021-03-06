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
    StringBuilder menu = new StringBuilder();

    // Display Menu Options
    menu.append("\nM E N U   OPTIONS");
    menu.append("\n=================");

    // loop through the options
    for (int i = 0; i < appOptions.size(); i++) {

      AAppOptions option = appOptions.get(i);
      menu.append(String.format("\n%d.  %s", i + 1, option.getName()));

    }

    // Print the Exit Option
    menu.append("\n0.  Exit\n\n");

    LOGGER.info(menu.toString());
  }

  private static void printUserChoice(AAppOptions option) {
    LOGGER.info(String.format("Here is the option you chose: %s\n\n", option.getName()));
  }

}
