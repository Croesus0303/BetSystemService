package com.example.lotteryservice;


import com.mongodb.client.FindIterable;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.ArrayList;

public interface lotteryRepository {

    String getLotteryInfo ();

}
