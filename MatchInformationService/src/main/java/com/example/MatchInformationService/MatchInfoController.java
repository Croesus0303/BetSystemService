package com.example.MatchInformationService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MatchInfoController implements MatchInfoRepository {

    MatchInfoService service= new MatchInfoService();

    @GetMapping(value = "/getMatchInfos")
    public String getMatchInfos(){

        return service.getMatchInfos().toString();
    }

    @PostMapping (value="/createCoupon")
    public String createCoupon(@RequestBody createCouponRequest CreateCouponRequest) {

        return service.createCoupon(CreateCouponRequest);
    }

    @GetMapping (value = "/checkCoupon")
    public String checkCoupon(@RequestBody Map<String,Object> json) {
        return service.checkCoupon(json);
    }


}


