package com.PayPal.taskPlanner.Services;

import com.PayPal.taskPlanner.DTO.UserDTO;
import com.PayPal.taskPlanner.Exceptions.AlreadyExistException;

public interface UserService {



     boolean addUser(UserDTO user) throws AlreadyExistException;

     boolean deleteUser();

}
