package lotto.controller;

import static lotto.controller.Constants.PERCENTAGE;

import java.util.Arrays;

public class EarningRateCalculator {

    public static float calculateEarningRate(String inputMomey) {
        int prizeSum = 0;
        for(CorrectNumber correctNumber : CorrectNumber.values()) {

        }
        return (float) (prizeSum / Integer.parseInt(inputMomey))*PERCENTAGE;
    }
}
