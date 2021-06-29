package main.app.menu_options;

import main.app.Keyboard;
import main.client.IMongoDBClient;

public class CalorieMenu implements IAppOptions {

    private int exitInt;

    private IMongoDBClient client;

    public CalorieMenu(IMongoDBClient client) {
        this.exitInt = 0;
        this.client = client;
    }

    @Override
    public String getName() {
        return "Calorie Menu";
    }

    @Override
    public void run() {

        int chosenOption = -1;
        Keyboard key = new Keyboard();

        String[] options = new String[2];

        options[0] = "See calories burned on one day";
        options[1] = "See calories over a time period";
        
        while(chosenOption != this.exitInt) {
            this.displayOptions(options);

            chosenOption = key.readInteger("Enter choice : ", "Error: Invalid input", this.exitInt, options.length);

            if (chosenOption != this.exitInt) {
                System.out.print("You chose to " + options[chosenOption - 1]);
            }
        }
        
        
    }

    private void displayOptions(String[] options) {
        System.out.println("CALORIE MENU");
        System.out.println("============");

        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d.  %s\n", i + 1, options[i]);
        }

        // Print the Exit Option
        System.out.println("0.  Exit\n");
    }

}