package lotto.domain;

import java.util.HashMap;
import java.util.List;
import lotto.Constants.NUMBER;
import lotto.Ranking;

public class Generator {
    private static final String WINNINGCOUNT = "winningCount";
    private static final String BONUSCOUNT = "bonusCount";

    private Generator() {
    }

    private static HashMap<String, Integer> getCorrectCount(Lotto lotto) {
        HashMap<String, Integer> result = new HashMap<String, Integer>() {{
            put(WINNINGCOUNT, NUMBER.ZERO);
            put(BONUSCOUNT, NUMBER.ZERO);
        }};

        counting(lotto, result);

        return result;
    }

    private static void counting(Lotto lotto, HashMap<String, Integer> result) {
        List<Integer> winningNumbers = Lotto.getWinningNumbers();
        int bonusNumber = Lotto.getBonusNumber();
        lotto.getNumbers()
                .stream()
                .mapToInt(Integer::intValue)
                .forEach(number -> {
                    if (winningNumbers.contains(number)) {
                        int prevWinningCount = result.get(WINNINGCOUNT);
                        result.put(WINNINGCOUNT, prevWinningCount + 1);
                    }
                    if (bonusNumber == number) {
                        int prevBonusCount = result.get(BONUSCOUNT);
                        result.put(BONUSCOUNT, prevBonusCount + 1);

                    }
                });
    }

    public static void countRank(Buyer buyer) {
        for (Lotto lotto : buyer.getPurchasedLotto()) {
            HashMap<String, Integer> correct = getCorrectCount(lotto);
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
