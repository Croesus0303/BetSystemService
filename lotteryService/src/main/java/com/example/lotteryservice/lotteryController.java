package com.example.lotteryservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class lotteryController {

    lotteryService service= new lotteryService();

    @GetMapping(value = "/getLotteryInfo")
    public String getLotteryInfo(){
        //return "Test";
        return service.getLotteryInfo();
    }
    @PostMapping(value = "/playLottery")
    public String playLottery(@RequestParam String userName){
        return service.playLottery(userName).toString();
    }
    @GetMapping(value = "/checkLottery")
    public String checkLotterty(@RequestParam String userName){
        return service.checkLottery(userName);
    }

}


