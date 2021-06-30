package com.example.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController implements UserRepository {

    UserService userService = new UserService();


    @PostMapping(value = "/createUser",params = {"UserName","Password"})
    public void createUser(@RequestParam(name = "UserName") String userName,@RequestParam(name = "Password") String password){
        userService.createUser(userName,password);
    }

    @PostMapping(value = "/loadMoney")
    public String loadMoney(@RequestBody Map<String,Object> json) {
        return userService.loadMoney(json);
    }

    @PostMapping(value = "/gameTransaction")
    public String gameTransaction(@RequestBody Map<String,Object> json) {
            return userService.gameTransaction(json);
    }


}


