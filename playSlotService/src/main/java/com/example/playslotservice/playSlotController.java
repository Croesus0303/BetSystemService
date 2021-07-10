package com.example.playslotservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class playSlotController {

    playSlotService service= new playSlotService();



    @GetMapping(value = "/playSlot")
    public String playSlot(){
        return service.playSlot().toString();
    }
}
