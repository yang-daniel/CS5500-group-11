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
                    int currDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                    String startDay = this.formatDate(1, month, year);
                    String endDay = this.formatDate(currDay, month, year);
                    int calBurned = this.client.getRangeCalories(startDay, endDay);
                    int points = calBurned * 2;
                    System.out.println("You have " + points + " points for this month.");
                } else if (chosenOption == 2) {
                    int[] startDay = this.collectDate(false, true);
                    String strStartDay = this.formatDate(startDay);
                    int[] endDay = startDay.clone();
                    endDay[1] = endDay[1] + 1;
                    if (endDay[1] > 12) {
                        endDay[1] = 1;
                        endDay[0] = endDay[0] + 1;
                    }
                    String strEndDay = this.formatDate(endDay);
                    int calBurned = this.client.getRangeCalories(strStartDay, strEndDay);
                    int points = calBurned * 2;
                    System.out.println("You have " + points + " points for the chosen month.");
                }
            }
        }
        System.out.println();
        System.out.println("Taking you back to the main menu...");
        System.out.println();
        
    }
    
}
