package com.example.demo.service;

import com.example.demo.Exception.UserException;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User editUser(long id, UserRequest userRequest) throws Throwable {
        User user = userRepository.findById(id).get();
        if(user!=null){
            user.setName(userRequest.getName());
            user.setAge(userRequest.getAge());
            user.setEmail(userRequest.getEmail());
            userRepository.save(user);
            return user;
        }
        else
        {
            throw new UserException().notFoundException("User Not Found with id " + id);
        }
    }

    public User deleteUser(long id) throws Throwable {
        User user = userRepository.findById(id).get();
        if(user != null){
            userRepository.deleteById(user.getId());
            return user;
        }
        else{
            throw new UserException().notFoundException("User Not Found with id " + id);
        }
    }

    public User addUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);
        return user;
    }
}
