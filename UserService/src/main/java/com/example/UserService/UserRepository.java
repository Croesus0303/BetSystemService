package com.example.UserService;

import org.springframework.stereotype.Service;

public interface UserRepository {

    void createUser (String name,String password);

}
