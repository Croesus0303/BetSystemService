package com.example.MatchInformationService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchInfoController {

    MatchInfoService service= new MatchInfoService();

    @GetMapping(value = "/getMatchInfos")
    public String getMatchInfos(){

        return service.getMatchInfos().toString();
    }


}


