package com.example.demo.service;

import com.example.demo.Controller.UserController;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;

    private UserRequest userRequest = new UserRequest(1,"name","abc@gmail.com",18);

    User user1 = new User(1,"Name",18,"abc@gmail.com");
    User user2 = new User(2,"Name",18,"abc@gmail.com");
    private List<User> getUserList(){
        List<User> list = new ArrayList<>(Arrays.asList(user1,user2));
//        list.add(user1);
//        list.add(user2);
        return list;
    }
    private User getUserFormUserRequest(){
        User user = new User();
        user.setId(userRequest.getId());
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        user.setEmail(userRequest.getEmail());
        return user;
    }
    @Mock
    private UserRepository userRepository;

    @Test
    void getUsers() {
        when(userRepository.findAll()).thenReturn(getUserList());
        List<User> userList = userService.getUsers();
        assertEquals(userList.size(),2);
        assertEquals(userList,getUserList());

    }

    @Test
    void editUser() throws Throwable {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));
        when(userRepository.save(user1)).thenReturn(user1);
        User user = getUserFormUserRequest();
        assertEquals(userService.editUser(1L,userRequest),user);
    }

    @Test
    void deleteUser() throws Throwable {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));
        assertEquals(userService.deleteUser(1L),user1);
        verify(userRepository).deleteById(1L);
    }

    @Test
    void addUser() {
        User user = getUserFormUserRequest();
        user.setId(0);
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(userService.addUser(userRequest),user);


    }
}