package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static int countLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / 1000;
    }

    public static int countMatchingNumbers(List<Integer> winningNumbers, List<Integer> playerNumbers) {
        List<Integer> intersection = new ArrayList<>(winningNumbers);
        intersection.removeAll(playerNumbers);

        if (intersection.isEmpty()) {
            return 0;
        }

        return intersection.size();
    }

    public static long getProfitRates(int purchaseAmount, int winningAmount) {
        return winningAmount / purchaseAmount;
    }
}
