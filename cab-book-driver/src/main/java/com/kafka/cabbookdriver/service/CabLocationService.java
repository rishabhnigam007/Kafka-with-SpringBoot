package com.kafka.cabbookdriver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.cabbookdriver.constant.AppConstant;
import com.kafka.cabbookdriver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
        return true;
    }

    public User createUser(User user) throws JsonProcessingException {
        String userJson = objectMapper.writeValueAsString(user); // Serialize User object to JSON
        kafkaTemplate.send(AppConstant.CAB_LOCATION, userJson);
        return user;
    }
}
