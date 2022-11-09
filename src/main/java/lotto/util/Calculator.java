package lotto.util;

public class Calculator {

    public static long getProfitRates(int purchaseAmount, int winningAmount) {
        return winningAmount / purchaseAmount;
    }
}
