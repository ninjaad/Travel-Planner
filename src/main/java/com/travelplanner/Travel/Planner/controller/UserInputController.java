package com.travelplanner.Travel.Planner.controller;

import com.travelplanner.Travel.Planner.dto.UserInput;
import com.travelplanner.Travel.Planner.model.UserInputEntity;
import com.travelplanner.Travel.Planner.service.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class UserInputController {

    @Autowired
    private UserInputService userInputService;

    @PostMapping("inputs")
    public ResponseEntity<UserInputEntity> saveInput(@RequestBody UserInput input, Principal principal)
    {
        String username = principal.getName();
        return userInputService.saveInput(input,username);
    }

    @GetMapping("inputs")
    public ResponseEntity<List<UserInputEntity>> getMyInputs(Principal principal) {
        String username = principal.getName();
        return userInputService.getInputsForUser(username);
    }
}
