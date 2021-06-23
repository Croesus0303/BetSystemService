package com.example.playrouletteservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class playRouletteService implements playRouletteRepository {

    public String playRoulette(){
        List<Integer> red = Arrays.asList(1,3,4,7,9,10,11,13,15,17,19,21,25,26,29,30);
        List<Integer> black = Arrays.asList(2,5,6,8,12,14,16,18,20,22,23,24,27,31,32);
        int luckyNumber = ThreadLocalRandom.current().nextInt(0, 33);
        boolean cift = luckyNumber%2==0;
        boolean tek = luckyNumber%2==1;
        boolean isRed = red.contains(luckyNumber);
        boolean isBlack = black.contains(luckyNumber);
        boolean Jackspot = luckyNumber==0;
        return "Kazanan sayı: "+luckyNumber+"\n"+"Çift: "+cift+"\tTek: "+tek+"\n"
                +"Siyah :"+isBlack+"\tKırmızı: "+isRed;

    }
}
