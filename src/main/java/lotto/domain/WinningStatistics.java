package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int MATCH_FIVE_CASE = 5;
    private static final int PERCENTAGE = 100;
    private static int compareWithAnswer(Lotto lotto, AnswerLotto answerLotto) {
        List<Integer> numbers = lotto.getLotto();
        List<Integer> winningNumbers = answerLotto.getAnswerLotto();
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static boolean compareWithBonusNumber(Lotto lotto, AnswerLotto answerLotto, int matchingCount) {
        if (matchingCount != MATCH_FIVE_CASE) {
            return false;
        }
        List<Integer> numbers = lotto.getLotto();
        int bonusNumber = answerLotto.getBonusNumber();
        return numbers.contains(bonusNumber);
    }

    public static Map<WinningRank, Integer> createWinningDetails() {
        Map<WinningRank, Integer> winningDetails = new EnumMap<>(WinningRank.class);
        Arrays.stream(WinningRank.values()).forEach(winningRank -> winningDetails.put(winningRank, 0));
        return winningDetails;
    }

    public static Map<WinningRank, Integer> getWinningDetails(LottoGroup lottoGroup, AnswerLotto answerLotto) {
        Map<WinningRank, Integer> winningDetails = createWinningDetails();

        for (Lotto lotto : lottoGroup.getLottoGroup()) {
            int count = compareWithAnswer(lotto, answerLotto);
            boolean containsBonusNumber = compareWithBonusNumber(lotto, answerLotto, count);
            WinningRank winningRank = WinningRank.findWinningRank(count, containsBonusNumber);
            winningDetails.replace(winningRank, winningDetails.get(winningRank) + 1);
        }

        return winningDetails;
    }
    public static long getWinningAmount(Map<WinningRank, Integer> winningDetails) {
        return winningDetails.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
    }
    public static double getLottoYield(long winningAmount, int money) {
        double lottoYield = PERCENTAGE + (double) (winningAmount - money) / money * PERCENTAGE;
        return Math.round(lottoYield * 10) / 10.0;
    }
}