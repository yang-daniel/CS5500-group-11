package main.app.menu_options;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

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

        options[0] = "See current points and badges";
        options[1] = "See points and badges for a prior month";
        
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
                    this.calcAndPrintBadgesFor(startDay, endDay);
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
                    this.calcAndPrintBadgesFor(strStartDay, strEndDay);
                }
            }
        }
        LOGGER.info("\n\nTaking you back to the main menu...\n\n");
    }

    private void calcAndPrintPointsFor(String startDay, String endDay) {
        int calBurned = this.client.getRangeCalories(startDay, endDay);
        int numDiffActivities = this.client.getUniqueRangeActivities(startDay, endDay).size();
        int caloriePoints = calBurned * 2;
        int activityPoints = numDiffActivities * 4;
        StringBuilder str = new StringBuilder();
        str.append("\nYou have " + caloriePoints + " points earned from burning calories ");
        str.append("\nand you have " + activityPoints + " points earned from completing various activities this month.");
        str.append("\nThis gives you a total of " + (caloriePoints + activityPoints) + " points for this month.");
        LOGGER.info(str.toString());
    }

    private void calcAndPrintBadgesFor(String startDay, String endDay) {
        StringBuilder str = new StringBuilder();
        str.append("Badges earned:");
        str.append(this.earned10kCalsBadge(startDay, endDay));
        str.append(this.earned250kStepsBadge(startDay, endDay));
        str.append(this.earnedVarietyExerciseBadge(startDay, endDay));
        str.append(this.earned15WalksBadge(startDay, endDay));
        str.append(this.earned30WalksBadge(startDay, endDay));
        LOGGER.info(str.toString());
    }

    private String earned10kCalsBadge(String startDay, String endDay) {
        if (this.client.getRangeCalories(startDay, endDay) >= 10000) {
            return "\n - 10,000+ Calorie Burn in One Month!";
        }
        return "";
    }

    private String earned250kStepsBadge(String startDay, String endDay) {
        if  (this.client.getRangeSteps(startDay, endDay) >= 250000) {
            return "\n - 250,000+ Steps Taken in One Month!";
        }
        return "";
    }

    private String earnedVarietyExerciseBadge(String startDay, String endDay) {
        if  (this.client.getUniqueRangeActivities(startDay, endDay).size() >= 3) {
            return "\n - 3+ Different Activities Completed in One Month!";
        }
        return "";
    }

    private String earned30WalksBadge(String startDay, String endDay) {
        List<String> allActivities = this.client.getAllRangeActivities(startDay, endDay);
        if  (Collections.frequency(allActivities, "walking") >= 30) {
            return "\n - 30 Walks in One Month!";
        }
        else return "";
    }

    private String earned15WalksBadge(String startDay, String endDay) {
        List<String> allActivities = this.client.getAllRangeActivities(startDay, endDay);
        if  (Collections.frequency(allActivities, "walking") >= 30) {
            return "\n - 15 Walks in One Month!";
        }
        else return "";
    }


    
}
