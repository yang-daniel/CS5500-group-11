package main.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    private static Logger LOGGER = LogManager.getLogger(MainApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}