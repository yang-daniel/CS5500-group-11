package main.app;
/**
 * This class represent the Options that this applications offers.
 *Main purpose is reusability.
 */
public class AppOptions {

    private String optionName;
  
    AppOptions(String optionName) {
      this.optionName = optionName;
  
    }
  
    public String getName() {
      return optionName;
    }
  
  }
  