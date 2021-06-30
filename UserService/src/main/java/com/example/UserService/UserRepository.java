package com.example.UserService;

import com.mongodb.util.JSON;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserRepository {

    void createUser (String name,String password);
    String loadMoney (Map<String,Object> json);
    String gameTransaction(Map<String,Object> json);

}
