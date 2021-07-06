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

  /**
   * @return name of the app option
   */
  public String getName() {
    return this.name;
  }

  /**
   * Starts up the menu.
   */
  abstract public void run();

  /**
   * Requests the date from the user. If getDay is false, returns day as 01. If getMonth is false, returns month as 01.
   * @return the date in yyyyMMdd format
   */
  protected int[] collectDate(boolean getDay, boolean getMonth) {
    int day = 1;
    int month = 1;
    if (getDay) {
      day = this.key.readInteger("Day: ", "Error: Invalid input", 1, 31);

    }
    if (getMonth) {
      month = this.key.readInteger("Month: ", "Error: Invalid input", 1, 12);
    }
    int year = this.key.readInteger("Year: ", "Error: Invalid input", 1000, Calendar.getInstance().get(Calendar.YEAR));
    System.out.println("You have entered " + month + "/" + day + "/" + year);
    System.out.println();
    return new int[]{day, month, year};
  }

  /**
   * Displays the given options list as...
   * name in all caps
   * equal signs as long as name length
   * options with selection numbers
   * exit option
   * @param options
   */
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

  /**
   * Formats given date into a String.
   * @param day 
   * @param month
   * @param year
   * @return String representing date in yyyyMMdd format
   */
  protected String formatDate(int day, int month, int year) {
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

  /**
   * Formats given date into a String. Expected input has a length of 3.
   * @param day 
   * @param month
   * @param year
   * @return String representing date in yyyyMMdd format
   */
  protected String formatDate(int[] dayMonthYear) {
    return this.formatDate(dayMonthYear[0], dayMonthYear[1], dayMonthYear[2]);
  }
  
}
  