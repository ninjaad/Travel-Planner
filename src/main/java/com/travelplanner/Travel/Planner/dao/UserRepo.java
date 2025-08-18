package com.travelplanner.Travel.Planner.dao;

import com.travelplanner.Travel.Planner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
