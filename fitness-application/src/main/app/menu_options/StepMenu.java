package main.app.menu_options;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.client.IMongoDBClient;

public class StepMenu extends AAppOptions{

    private static Logger LOGGER = LogManager.getLogger(StepMenu.class.getName());

    public StepMenu(IMongoDBClient client) {
        super(client);
        this.name = "Steps Menu";
    }

    @Override
    public void run() {
        
        int chosenOption = -1;

        String[] options = new String[2];

        options[0] = "See steps taken on one day";
        options[1] = "See steps taken over a time period";
        
        while(chosenOption != this.exitInt) {
            this.displayOptions(options);

            chosenOption = key.readInteger("Enter choice : ", "Error: Invalid input", this.exitInt, options.length);

            if (chosenOption != this.exitInt) {
                LOGGER.info("\nYou chose to " + options[chosenOption - 1].toLowerCase() + ".");

                if (chosenOption == 1) {
                    LOGGER.info("\nPlease enter the date you would like to see:");
                    String date = this.formatDate(this.collectDate(true, true));
                    int steps = this.client.getDaySteps(date);
                    LOGGER.info("\nThere were " + steps + " steps taken on that day.");
                } else if (chosenOption == 2) {
                    LOGGER.info("\nPlease enter the start date of the time period you would like to see:");
                    String startDate = super.formatDate(super.collectDate(true, true));
                    LOGGER.info("\nPlease enter the end date of the time period you would like to see:");
                    String endDate = super.formatDate(super.collectDate(true, true));
                    int steps = this.client.getRangeSteps(startDate, endDate);
                    LOGGER.info("\nThere were " + steps + " steps taken in that date range.");
                }
            }
        }
        LOGGER.info("\n\nTaking you back to the main menu...\n\n");
    }
    
}
