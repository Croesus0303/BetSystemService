package com.example.MatchInformationService;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class createCouponRequest {
    @JsonProperty("matches")
    List<MatchInfo> matches = new ArrayList<MatchInfo>();
    @JsonProperty("Amount")
     double Amount = 0.0;
    String _id="";
}

 class MatchInfo{
     @JsonProperty("MatchId")
     String MatchId;
     @JsonProperty("Result")

     Integer result;
     @JsonProperty("Rate")

     Double rate;
}
