package lotto.controller;

import static lotto.controller.Constants.PERCENTAGE;

import java.util.Arrays;
import lotto.Lotto;
import lotto.model.LottoStorage;

public class EarningRateCalculator {

    public static double calculateEarningRate() {
        int inputMoney = Integer.parseInt(LottoStorage.getInputMoney());
        int prizeSum = 0;
        for(CorrectNumber correctNumber : LottoStorage.getResultCollectionStorage()) {
            prizeSum += correctNumber.getCashPrize();
        }
        return ((double)prizeSum / inputMoney) * PERCENTAGE;
    }
}
