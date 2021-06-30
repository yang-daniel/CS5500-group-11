package main.app.menu_options;

import main.client.IMongoDBClient;

public class RewardMenu extends AAppOptions {

    public RewardMenu(IMongoDBClient client) {
        super(client);
        this.name = "Rewards Menu";
    }

    @Override
    public void run() {
        
        int chosenOption = -1;

        String[] options = new String[2];

        options[0] = "See current points total";
        options[1] = "See current level";
        
        while(chosenOption != this.exitInt) {
            super.displayOptions(options);

            chosenOption = this.key.readInteger("Enter choice : ", "Error: Invalid input", this.exitInt, options.length);

            if (chosenOption != this.exitInt) {
                System.out.println("You chose to " + options[chosenOption - 1].toLowerCase() + ".");

                if (chosenOption == 1) {
                    System.out.println("This feature is not yet available. Please come back another time.");
                } else if (chosenOption == 2) {
                    System.out.println("This feature is not yet available. Please come back another time.");
                }
            }
        }
        System.out.println();
        System.out.println("Taking you back to the main menu...");
        System.out.println();
        
    }
    
}
