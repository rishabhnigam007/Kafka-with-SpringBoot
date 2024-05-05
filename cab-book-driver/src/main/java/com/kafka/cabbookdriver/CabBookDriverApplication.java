package com.kafka.cabbookdriver;

import com.kafka.cabbookdriver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookDriverApplication implements CommandLineRunner {

    @Autowired
    private CabLocationService cabLocationService;

    public static void main(String[] args) {
        SpringApplication.run(CabBookDriverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java -jar yourApp.jar <location>");
            return;
        }

        String location = args[0];
        boolean result = cabLocationService.updateLocation(location);
        if (result) {
            System.out.println("Cab location updated successfully.");
        } else {
            System.out.println("Failed to update cab location.");
        }
    }

}
