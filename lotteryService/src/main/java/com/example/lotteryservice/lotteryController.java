package com.example.lotteryservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class lotteryController {

    lotteryService service= new lotteryService();

    @GetMapping(value = "/getLotteryInfos")
    public String getLotteryInfo(){
        //return "Test";
        return service.getLotteryInfo().toString();
    }


}


