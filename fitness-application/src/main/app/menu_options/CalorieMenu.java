package main.app.menu_options;

import main.client.IMongoDBClient;

public class CalorieMenu extends AAppOptions {

    public CalorieMenu(IMongoDBClient client) {
        super(client);
        this.name = "Calorie Menu";
    }

    public void run() {

        int chosenOption = -1;

        String[] options = new String[2];

        options[0] = "See calories burned on one day";
        options[1] = "See calories over a time period";
        
        while(chosenOption != this.exitInt) {
            this.displayOptions(options);

            chosenOption = key.readInteger("Enter choice : ", "Error: Invalid input", this.exitInt, options.length);

            if (chosenOption != this.exitInt) {
                System.out.println("You chose to " + options[chosenOption - 1].toLowerCase() + ".");

                if (chosenOption == 1) {
                    System.out.println("Please enter the date you would like to see:");
                    String date = super.formatDate(super.collectDate(true, true));
                    int calBurned = this.client.getDayCalories(date);
                    System.out.println("There were " + calBurned + " calories burned on that day.");
                } else if (chosenOption == 2) {
                    System.out.println("Please enter the start date of the time period you would like to see:");
                    String startDate = super.formatDate(super.collectDate(true, true));
                    System.out.println("Please enter the end date of the time period you would like to see:");
                    String endDate = super.formatDate(super.collectDate(true, true));
                    int calBurned = this.client.getRangeCalories(startDate, endDate);
                    System.out.println("There were " + calBurned + " calories burned in that date range.");
                }
            }
        }
        System.out.println();
        System.out.println("Taking you back to the main menu...");
        System.out.println();
        
    }

}