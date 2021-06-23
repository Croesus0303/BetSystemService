package com.example.playslotservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/playSlot")

public class playSlotController {

    playSlotService service= new playSlotService();



    @GetMapping

    public String playSlot(){

        return service.playSlot().toString();
    }
}
