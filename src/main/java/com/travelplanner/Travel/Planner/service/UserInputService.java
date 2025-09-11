package com.travelplanner.Travel.Planner.service;

import com.travelplanner.Travel.Planner.dao.UserInputRepository;
import com.travelplanner.Travel.Planner.dao.UserRepo;
import com.travelplanner.Travel.Planner.dto.UserInput;
import com.travelplanner.Travel.Planner.model.User;
import com.travelplanner.Travel.Planner.model.UserInputEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInputService {

    @Autowired
    private UserInputRepository userInputRepository;

    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<UserInputEntity> saveInput(UserInput input, String username)
    {
        User user = userRepo.findByUsername(username);
        if(user==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            UserInputEntity inputEntity = new UserInputEntity();
            inputEntity.setBudget(input.getBudget());
            inputEntity.setDays(input.getDays());
            inputEntity.setPeople(input.getPeople());
            inputEntity.setSeason(input.getSeason());
            inputEntity.setUser(user);

            UserInputEntity savedInput = userInputRepository.save(inputEntity);

            if(savedInput.getId()==0){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(savedInput,HttpStatus.CREATED);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<UserInputEntity>> getInputsForUser(String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            List<UserInputEntity> inputs = userInputRepository.findByUser(user);
            return new ResponseEntity<>(inputs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
