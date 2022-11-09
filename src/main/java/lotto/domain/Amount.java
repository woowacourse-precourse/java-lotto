package lotto.domain;

import java.util.Map;

public class Amount {
    private final static int lottoAmount = 1000;

    public int calculateNumberOfPurchases(int inputMoney) {
        int NumberOfPurchases = inputMoney / lottoAmount;
        if (inputMoney % lottoAmount != 0) {
            throw new IllegalArgumentException();
        }
        return NumberOfPurchases;
    }

    public double calculateEarningRate() {
        return 0;
    }
}
