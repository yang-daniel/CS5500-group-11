package main.app.menu_options;

import java.util.Calendar;

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
        options[1] = "See points for a prior month";
        
        while(chosenOption != this.exitInt) {
            super.displayOptions(options);

            chosenOption = this.key.readInteger("Enter choice : ", "Error: Invalid input", this.exitInt, options.length);

            if (chosenOption != this.exitInt) {
                System.out.println("You chose to " + options[chosenOption - 1].toLowerCase() + ".");

                if (chosenOption == 1) {
                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    int month = Calendar.getInstance().get(Calendar.MONTH);
                    int currDay = Calendar.getInstance().get(Calendar.DATE);
                    String startDay = this.formatDate(1, month, year);
                    String endDay = this.formatDate(currDay, month, year);
                    int calBurned = this.client.getRangeCalories(startDay, endDay);
                    int points = calBurned * 2;
                    System.out.println("You have " + points + " points for this month.");
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
