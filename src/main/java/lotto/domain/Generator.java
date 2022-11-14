package lotto.domain;

import java.util.HashMap;
import java.util.List;
import lotto.Ranking;

public class Generator {
    private static final String WINNINGCOUNT = "winningCount";
    private static final String BONUSCOUNT = "bonusCount";

    private Generator() {
    }

    private static HashMap<String, Integer> judgeWinningCount(Lotto lotto) {
        List<Integer> winningNumbers = Lotto.getWinningNumbers();
        int bonusNumber = Lotto.getBonusNumber();

        final int[] winningCount = {0};
        final int[] bonusCount = {0};
        lotto.getNumbers()
                .stream()
                .mapToInt(Integer::intValue)
                .forEach(number -> {
                    if (winningNumbers.contains(number)) {
                        winningCount[0]++;
                    }
                    if (bonusNumber == number) {
                        bonusCount[0]++;
                    }
                });

        HashMap<String, Integer> result = new HashMap<String, Integer>();
        result.put(WINNINGCOUNT, winningCount[0]);
        result.put(BONUSCOUNT, bonusCount[0]);
        return result;
    }

    public static void calculateRank(Buyer buyer) {
        for (Lotto lotto : buyer.getPurchasedLotto()) {
            HashMap<String, Integer> correct = judgeWinningCount(lotto);
            Ranking rank = Ranking.getRank(correct.get(WINNINGCOUNT), correct.get(BONUSCOUNT));
            Buyer.setWinningSummary(buyer, rank.getLabel());
        }

    }

    public static double calculateProfit(int purchased, long totalPrize) {
        double profit = (double) totalPrize / purchased * 100 * 10;
        double result = Math.round(profit);
        return result / 10;
    }
}
