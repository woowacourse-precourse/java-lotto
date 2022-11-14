package lotto.domain;

import java.util.*;

public class Calculator {
    public static Map<Result, Integer> calculateResult(List<Lotto> lottos, Set<Integer> winningNumbers, int bonusNumber) {
        Map<Result, Integer> resultCounts = initializeMap();

        for (Lotto lotto : lottos) {
            Result result = lotto.computeResult(winningNumbers, bonusNumber);
            resultCounts.put(result, resultCounts.get(result) + 1);
        }

        return resultCounts;
    }

    private static Map<Result, Integer> initializeMap() {
        Map<Result, Integer> resultCounts = new EnumMap<>(Result.class);

        resultCounts.put(Result.THREE, 0);
        resultCounts.put(Result.FOUR, 0);
        resultCounts.put(Result.FIVE, 0);
        resultCounts.put(Result.FIVEWITHBONUS, 0);
        resultCounts.put(Result.SIX, 0);

        return resultCounts;
    }

    public static double calculateYield(int money, int earn) {
        if (money == 0 || earn == 0) {
            return 0;
        }
        return  ((double) money / (double) earn) * 100;
    }
}
