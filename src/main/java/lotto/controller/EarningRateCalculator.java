package lotto.controller;

import static lotto.controller.Constants.PERCENTAGE;

import java.util.Arrays;

public class EarningRateCalculator {

    public static float calculateEarningRate(CorrectNumber correctNumber, int inputMomey) {
        return ((float) correctNumber.getCashPrize() / inputMomey) * PERCENTAGE;
    }
}
