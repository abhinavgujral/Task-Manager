package com.PayPal.taskPlanner.Services;

import com.PayPal.taskPlanner.DTO.UserDTO;
import com.PayPal.taskPlanner.Exceptions.UserAlreadyExistException;

public interface UserService {



     boolean addUser(UserDTO user) throws UserAlreadyExistException;

     boolean deleteUser();

}
