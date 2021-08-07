package main.app.menu_options;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.client.IMongoDBClient;

public class ActivityMenu extends AAppOptions {

    private static Logger LOGGER = LogManager.getLogger(ActivityMenu.class.getName());

    public ActivityMenu(IMongoDBClient client) {
        super(client);
        this.name = "Activity Menu";
    }

    @Override
    public void run() {
        
        int chosenOption = -1;

        String[] options = new String[2];

        options[0] = "See activities completed on a day";
        options[1] = "See activities completed over a time period";
        
        while(chosenOption != this.exitInt) {
            super.displayOptions(options);

            chosenOption = this.key.readInteger("Enter choice : ", "Error: Invalid input", this.exitInt, options.length);

            if (chosenOption != this.exitInt) {
                LOGGER.info("\nYou chose to " + options[chosenOption - 1].toLowerCase() + ".");

                if (chosenOption == 1) {
                    LOGGER.info("\nPlease enter the date you would like to see:");
                    String date = super.formatDate(super.collectDate(true, true));
                    List<String> activities = this.client.getUniqueDayActivities(date);
                    this.printActivities(activities);
                } else if (chosenOption == 2) {
                    LOGGER.info("\nPlease enter the start date of the time period you would like to see:");
                    String startDate = super.formatDate(super.collectDate(true, true));
                    LOGGER.info("\nPlease enter the end date of the time period you would like to see:");
                    String endDate = super.formatDate(super.collectDate(true, true));
                    List<String> activities = this.client.getUniqueRangeActivities(startDate, endDate);
                    this.printActivities(activities);
                } 
            }
        }
        LOGGER.info("\n\nTaking you back to the main menu...\n\n");
    }

    private void printActivities(List<String> activities) {
        if (activities.isEmpty()) {
            LOGGER.info("\nYou did not complete any activities.");
        } else {
            StringBuilder str = new StringBuilder();
            str.append("\nYou completed the following activities:");
            for (String a: activities) {
                str.append("* " + a);
            }
            LOGGER.info(str.toString());
        }
    }
    
}
