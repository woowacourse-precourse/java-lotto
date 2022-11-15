package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.*;

public class Calculator {
    private static Map<Result, Integer> resultCounts;

    private Calculator() {}

    public static Map<Result, Integer> calculateResult(List<Lotto> lottos, Set<Integer> winningNumbers, int bonusNumber) {
        initializeMap();

        for (Lotto lotto : lottos) {
            Result computedResult = lotto.computeResult(winningNumbers, bonusNumber);
            resultCounts.computeIfPresent(computedResult, (result, count) -> count + 1);
        }

        return resultCounts;
    }

    public static int calculateEarn(List<Lotto> lottos, Set<Integer> winningNumbers, int bonusNumber) {
        int earn = 0;

        for (Lotto lotto : lottos) {
            Result computedResult = lotto.computeResult(winningNumbers, bonusNumber);
            earn += stringToInt(computedResult.getMoney());
        }

        return earn;
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

    public static double calculateYield(int money, int earn) {
        if (money == 0 || earn == 0) {
            return 0;
        }
        return ((double) earn / (double) money) * 100;
    }
}
