package com.example.betmatchservice;

import org.springframework.stereotype.Service;

public interface betMatchRepository {

    void betMatch (String userName, String matchId, String bet, String Amount);


}
