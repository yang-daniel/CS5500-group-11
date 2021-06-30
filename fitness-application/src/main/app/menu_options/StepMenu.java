package main.app.menu_options;

import main.client.IMongoDBClient;

public class StepMenu extends AAppOptions{

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
                System.out.println("You chose to " + options[chosenOption - 1].toLowerCase() + ".");

                if (chosenOption == 1) {
                    System.out.println("Please enter the date you would like to see:");
                    String date = this.collectDate();
                    int steps = this.client.getDaySteps(date);
                    System.out.println("There were " + steps + " steps taken on that day.");
                } else if (chosenOption == 2) {
                    System.out.println("Please enter the start date of the time period you would like to see:");
                    String startDate = this.collectDate();
                    System.out.println("Please enter the end date of the time period you would like to see:");
                    String endDate = this.collectDate();
                    int steps = this.client.getRangeSteps(startDate, endDate);
                    System.out.println("There were " + steps + " steps taken in that date range.");
                }
            }
        }
        System.out.println();
        System.out.println("Taking you back to the main menu...");
        System.out.println();
        
        
    }
    
}
