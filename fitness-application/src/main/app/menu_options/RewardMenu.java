package main.app.menu_options;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import main.client.IMongoDBClient;

public class RewardMenu extends AAppOptions {

    private static Logger LOGGER = LogManager.getLogger(RewardMenu.class.getName());

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
                LOGGER.info("\nYou chose to " + options[chosenOption - 1].toLowerCase() + ".");

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
        LOGGER.info("\n\nTaking you back to the main menu...\n\n");
    }

    private void calcAndPrintPointsFor(String startDay, String endDay) {
        int calBurned = this.client.getRangeCalories(startDay, endDay);
        int numDiffActivities = this.client.getRangeActivities(startDay, endDay).size();
        int caloriePoints = calBurned * 2;
        int activityPoints = numDiffActivities * 4;
        StringBuilder str = new StringBuilder();
        str.append("\nYou have " + caloriePoints + " points earned from burning calories ");
        str.append("\nand you have " + activityPoints + " points earned from completing various activities this month.");
        str.append("\nThis gives you a total of " + (caloriePoints + activityPoints) + " points for this month.");
        LOGGER.info(str.toString());
    }
    
}
