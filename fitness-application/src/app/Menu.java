import java.util.ArrayList;

/**
 * This class represent the Menu display.
 *
 */
public class Menu {

  /**
   * This method displays the menu.
   * @param appOptions - the options of the Menu
   */
  public static void displayMenu(ArrayList<AppOptions> appOptions) {

    // Display Menu Options
    System.out.println("M E N U   OPTIONS");
    System.out.println("=================");

    // loop through the options
    for (int i = 0; i < appOptions.size(); i++) {

      AppOptions option = appOptions.get(i);
      System.out.printf("%d.  %s\n", i + 1, option.getName());

    }

    // Print the Exit Option
    System.out.println("0.  Exit\n");

  }

  public static void main(String[] args) {

    ArrayList<AppOptions> MenuOptions = new ArrayList<AppOptions>();

    // Options Menu data
    MenuOptions.add(new AppOptions("Calories"));
    MenuOptions.add(new AppOptions("Steps"));
    MenuOptions.add(new AppOptions("Rewards"));

    displayMenu(MenuOptions);

    int userChoice;
    int EXIT = 0;

    // Create a keyboard object for input validation.
    Keyboard key = new Keyboard();

    userChoice = key.readInteger("Enter choice : ", "Error: Invalid input", EXIT,
        MenuOptions.size());

    // Menu loop.
    while (userChoice != EXIT) {

      // just to demonstrate i saved the choice of the user and can use it to query
      // the db.
      printUserChoice(userChoice, MenuOptions);

      // Display menu again.
      displayMenu(MenuOptions);

      userChoice = key.readInteger("Enter choice : ", "Error: Invalid input", EXIT,
          MenuOptions.size());

    }
    System.out.println("GoodBye....");
    System.out.println("...........");

  }

  private static void printUserChoice(int userChoice, ArrayList<AppOptions> menuOptions) {

    AppOptions option = menuOptions.get(userChoice - 1);

    System.out.printf("Here is the Option You chose: %s\n", option.getName());

  }

}
