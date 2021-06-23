package com.example.playslotservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class playSlotService implements playSlotRepository{
    Random rand = new Random();
    public List<String> slotItems = Arrays.asList("$","#","&","*","%");
    public String playSlot(){
        String slotResult=slotItems.get(rand.nextInt(slotItems.size()));
        slotResult = slotResult + slotItems.get(rand.nextInt(slotItems.size()));
        slotResult = slotResult + slotItems.get(rand.nextInt(slotItems.size()));
        String result="You Lost!";
        if(slotResult.charAt(0)==slotResult.charAt(1) && slotResult.charAt(1)==slotResult.charAt(2)){
            result="You Won!";
        }
        return slotResult +" "+result;
    }
}
