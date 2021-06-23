package com.example.playrouletteservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/playRoulette")

public class playRouletteController {

    playRouletteService service= new playRouletteService();

    @GetMapping

    public String playRoulette(){

        return service.playRoulette();
    }
}
