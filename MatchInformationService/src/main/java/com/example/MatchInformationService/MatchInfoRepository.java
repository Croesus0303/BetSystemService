package com.example.MatchInformationService;


import com.mongodb.client.FindIterable;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Map;

public interface MatchInfoRepository {

    String getMatchInfos ();
    String createCoupon (createCouponRequest request);
    String checkCoupon(Map<String,Object> json);

}
