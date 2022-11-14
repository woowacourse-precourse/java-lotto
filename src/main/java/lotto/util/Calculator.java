package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.*;

public class Calculator {
    private static Map<Result, Integer> resultCounts;
    private static int earn;

    public static Map<Result, Integer> calculateResult(List<Lotto> lottos, Set<Integer> winningNumbers, int bonusNumber) {
        initializeMap();
        earn = 0;

        for (Lotto lotto : lottos) {
            Result result = lotto.computeResult(winningNumbers, bonusNumber);
            resultCounts.put(result, resultCounts.get(result) + 1);
            earn += stringToInt(result.getMoney());
        }

        return resultCounts;
    }

    private static void initializeMap() {
        resultCounts = new EnumMap<>(Result.class);

        resultCounts.put(Result.THREE, 0);
        resultCounts.put(Result.FOUR, 0);
        resultCounts.put(Result.FIVE, 0);
        resultCounts.put(Result.FIVEWITHBONUS, 0);
        resultCounts.put(Result.SIX, 0);
    }

    private static int stringToInt(String money) {
        return Integer.parseInt(money.replace(",", ""));
    }

    public static double calculateYield(int money) {
        if (money == 0 || earn == 0) {
            return 0;
        }
        return  ((double) money / (double) earn) * 100;
    }
}
