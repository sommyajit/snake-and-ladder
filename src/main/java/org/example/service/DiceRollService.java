package org.example.service;

import java.util.Random;

public class DiceRollService {
    public static int diceRoll(){
        return new Random().nextInt(6)+1;
    }
}
