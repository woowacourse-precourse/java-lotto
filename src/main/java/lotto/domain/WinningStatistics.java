package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningStatistics {

    public static Map<WinningRank, Integer> getWinningDetails(Lottos lottos, WinningLotto winningLotto) {
        Map<WinningRank, Integer> winningDetails = WinningRank.generateWinningDetails();
        for (Lotto lotto : lottos.getLottos()) {
            int matchingCount = compareNumbersWithWinningNumbers(lotto, winningLotto);
            boolean containsBonusNumber = compareNumbersWithBonusNumber(lotto, winningLotto, matchingCount);
            WinningRank winningRank = WinningRank.findWinningRank(matchingCount, containsBonusNumber);
            winningDetails.replace(winningRank, winningDetails.get(winningRank) + 1);
        }
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
        if (matchingCount != 5) return false;
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        return numbers.contains(bonusNumber);
    }
    
    public static double getLottoYield(Map<WinningRank, Integer> winningDetails, int money) {
        long winningAmount = winningDetails.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .mapToLong(entry -> (long) entry.getKey().getWinningPrice() * entry.getValue())
                .sum();
        return 100 + (double)(winningAmount - money) / money * 100;
    }
}
