package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int AT_LEAST_THIRD_PLACE = 5;
    private static final int PERCENTAGE = 100;
    private static final int INITIAL_VALUE = 0;

    public static Map<WinningRank, Integer> getWinningDetails(Lottos lottos, WinningLotto winningLotto) {
        Map<WinningRank, Integer> winningDetails = generateWinningDetails();
        for (Lotto lotto : lottos.getLottos()) {
            int matchingCount = compareNumbersWithWinningNumbers(lotto, winningLotto);
            boolean containsBonusNumber = compareNumbersWithBonusNumber(lotto, winningLotto, matchingCount);
            WinningRank winningRank = WinningRank.findWinningRank(matchingCount, containsBonusNumber);
            winningDetails.replace(winningRank, winningDetails.get(winningRank) + 1);
        }
        return winningDetails;
    }

    public static Map<WinningRank, Integer> generateWinningDetails() {
        Map<WinningRank, Integer> winningDetails = new EnumMap<>(WinningRank.class);
        Arrays.stream(WinningRank.values()).forEach(winningRank -> winningDetails.put(winningRank, INITIAL_VALUE));
        return winningDetails;
    }

    private static int compareNumbersWithWinningNumbers(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static boolean compareNumbersWithBonusNumber(Lotto lotto, WinningLotto winningLotto, int matchingCount) {
        if (matchingCount != AT_LEAST_THIRD_PLACE) {
            return false;
        }
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        return numbers.contains(bonusNumber);
    }

    public static long getWinningAmount(Map<WinningRank, Integer> winningDetails) {
        return winningDetails.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinningPrice() * entry.getValue())
                .sum();
    }

    public static double getLottoYield(long winningAmount, int money) {
        double lottoYield = PERCENTAGE + (double) (winningAmount - money) / money * PERCENTAGE;
        return Math.round(lottoYield * 10) / 10.0;
    }
}
