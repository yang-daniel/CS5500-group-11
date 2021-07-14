package main.app.menu_options;

import java.util.List;

import main.client.IMongoDBClient;

public class ActivityMenu extends AAppOptions {

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
                System.out.println("You chose to " + options[chosenOption - 1].toLowerCase() + ".");

                if (chosenOption == 1) {
                    System.out.println("Please enter the date you would like to see:");
                    String date = super.formatDate(super.collectDate(true, true));
                    List<String> activities = this.client.getDayActivities(date);
                    this.printActivities(activities);
                } else if (chosenOption == 2) {
                    System.out.println("Please enter the start date of the time period you would like to see:");
                    String startDate = super.formatDate(super.collectDate(true, true));
                    System.out.println("Please enter the end date of the time period you would like to see:");
                    String endDate = super.formatDate(super.collectDate(true, true));
                    List<String> activities = this.client.getRangeActivities(startDate, endDate);
                    this.printActivities(activities);
                } 
            }
        }
        System.out.println();
        System.out.println("Taking you back to the main menu...");
        System.out.println();
        
    }

    private void printActivities(List<String> activities) {
        if (activities.isEmpty()) {
            System.out.println("You did not complete any activities.");
        } else {
            System.out.println("You completed the following activities:");
            for (String a: activities) {
                System.out.println("* " + a);
            }
        }
    }
    
}
