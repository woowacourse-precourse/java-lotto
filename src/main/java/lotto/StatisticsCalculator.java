package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StatisticsCalculator {
    public static Map<LottoPrize, Integer> calculateStatistics(List<Lotto> generatedLottos,
                                                               WinningNumber winningNumber) {
        Map<LottoPrize, Integer> statistics = initializeCountPerPrize();
        generatedLottos.forEach(lotto -> {
            LottoComparator.compareAndCountMatchLotto(statistics, lotto, winningNumber);
        });
        return statistics;
    }

    public static double calculateRateOfReturn(int principal, Map<LottoPrize, Integer> statistics) {
        double sumOfReward = 0;
        for (Entry<LottoPrize, Integer> prizeToCount : statistics.entrySet()) {
            sumOfReward += prizeToCount.getKey().reward * prizeToCount.getValue();
        }
        return Math.round(sumOfReward / principal * 100 * 10) / 10.0;
    }

    private static Map<LottoPrize, Integer> initializeCountPerPrize() {
        Map<LottoPrize, Integer> statistics = new HashMap<>();
        for (LottoPrize prize : LottoPrize.values()) {
            statistics.put(prize, 0);
        }
        return statistics;
    }
}
