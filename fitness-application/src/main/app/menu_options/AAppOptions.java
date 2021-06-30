package main.app.menu_options;

import java.util.Calendar;

import main.app.Keyboard;
import main.client.IMongoDBClient;

/**
 * This class represent the Options that this applications offers.
 * Main purpose is reusability.
 */
public abstract class AAppOptions {

  protected String name;
  protected Keyboard key;
  protected int exitInt;
  protected IMongoDBClient client;

  public AAppOptions(IMongoDBClient client) {
    this.name = "";
    this.key = new Keyboard();
    this.exitInt = 0;
    this.client = client;
  }
  public String getName() {
    return this.name;
  }

  abstract public void run();

  protected String collectDate() {
    int day = this.key.readInteger("Day: ", "Error: Invalid input", 1, 31);
    int month = this.key.readInteger("Month: ", "Error: Invalid input", 1, 12);
    int year = this.key.readInteger("Year: ", "Error: Invalid input", 1000, Calendar.getInstance().get(Calendar.YEAR));
    System.out.println("You have entered " + month + "/" + day + "/" + year);
    System.out.println();
    String strDay = "" + day;
    String strMonth = "" + month;
    if (day < 10) {
        strDay = "0" + day;
    }
    if (month < 10) {
        strMonth = "0" + month;
    }
    return year + "" + strMonth + "" + strDay;
  }

  protected void displayOptions(String[] options) {
    System.out.println();
    System.out.println(this.name.toUpperCase());
    System.out.println(new String(new char[this.name.length()]).replace("\0", "="));

    for (int i = 0; i < options.length; i++) {
        System.out.printf("%d.  %s\n", i + 1, options[i]);
    }

    // Print the Exit Option
    System.out.println(this.exitInt + ".  Exit\n");
}
  
}
  