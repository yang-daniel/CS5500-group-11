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
                    this.calcAndPrintPointsFor(startDay, endDay);
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
                    this.calcAndPrintPointsFor(strStartDay, strEndDay);
                }
            }
        }
        System.out.println();
        System.out.println("Taking you back to the main menu...");
        System.out.println();
        
    }

    private void calcAndPrintPointsFor(String startDay, String endDay) {
        int calBurned = this.client.getRangeCalories(startDay, endDay);
        int numDiffActivities = this.client.getRangeActivities(startDay, endDay).size();
        int caloriePoints = calBurned * 2;
        int activityPoints = numDiffActivities * 4;
        System.out.print("You have " + caloriePoints + " points earned from burning calories ");
        System.out.println("and you have " + activityPoints + " points earned from completing various activities this month.");
        System.out.println("This gives you a total of " + (caloriePoints + activityPoints) + " points for this month.");
    }
    
}
