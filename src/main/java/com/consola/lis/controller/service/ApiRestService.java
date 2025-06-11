package com.consola.lis.controller.service;

import com.consola.lis.model.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiRestService {

    private final UserService userService;

    public void registerNewUser(JsonNode jsonNode){
        userService.saveNewUser(jsonNode);
    }
}
