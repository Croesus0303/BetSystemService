package com.example.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserRepository userRepository;
    UserService userService = new UserService();


    @PostMapping(value = "/createUser",params = {"UserName","Password"})
    public void createUser(@RequestParam(name = "UserName") String userName,@RequestParam(name = "Password") String password){
        userService.createUser(userName,password);
    }

    @GetMapping(value = "/abc")
    public String deneme(){

        return "abc";
    }


}


