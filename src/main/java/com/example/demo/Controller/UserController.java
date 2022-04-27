package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.dto.UserRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

    @PutMapping("/edit/{id}")
    public User editUser(@PathVariable long id,@RequestBody UserRequest userRequest) throws Throwable {
        return userService.editUser(id,userRequest);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable long id) throws Throwable{
        return userService.deleteUser(id);
    }
}
