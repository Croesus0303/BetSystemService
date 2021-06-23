package com.example.betmatchservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class betMatchController {

    betMatchRepository betMatchRepository;
    betMatchService betMatchService = new betMatchService();


    @PostMapping(value = "/betMatch",params = {"UserName","MatchId","Bet,Amount"})
    public void betMatch(@RequestParam(name = "UserName") String userName,@RequestParam(name = "MatchId") String matchId
    		,@RequestParam(name = "MatchId") String bet,@RequestParam(name = "amount") String amount){
    	betMatchService.betMatch(userName,matchId,bet,amount);
    }

    @GetMapping(value = "/getBets",params= {"userName"})
    public String getBet(){

        return "userBet";
    }


}


