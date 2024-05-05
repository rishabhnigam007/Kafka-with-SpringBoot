package com.kafka.cabbookdriver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.cabbookdriver.model.User;
import com.kafka.cabbookdriver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    // Business logic

    @PutMapping("/")
    public ResponseEntity updateLocation() throws InterruptedException {

        int range = 10;
        while (range > 0) {
            cabLocationService.updateLocation(String.valueOf((int) (Math.random() * 10)));
            Thread.sleep(1000);
            range--;
        }

        return new ResponseEntity<>(Map.of("message", "Location Update"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody User user) throws InterruptedException, JsonProcessingException {
        cabLocationService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
