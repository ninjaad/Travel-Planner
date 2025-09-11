package com.travelplanner.Travel.Planner.dao;

import com.travelplanner.Travel.Planner.model.User;
import com.travelplanner.Travel.Planner.model.UserInputEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInputRepository extends JpaRepository<UserInputEntity,Integer>
{
    List<UserInputEntity>  findByUser(User user);
}
