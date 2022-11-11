package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningStatistics {

    public static Map<WinningRank, Integer> getWinningDetails(Lottos lottos, WinningLotto winningLotto) {
        Map<WinningRank, Integer> winningDetails = WinningRank.generateWinningDetails();
        for (Lotto lotto : lottos.getLottos()) {
            int matchingCount = compareNumbersWithWinningNumbers(lotto, winningLotto);
            boolean containsBonusNumber = false;
            if (matchingCount == 5) {
                containsBonusNumber = compareNumbersWithBonusNumber(lotto, winningLotto);
            }
            WinningRank winningRank = WinningRank.findWinningRank(matchingCount, containsBonusNumber);
            winningDetails.replace(winningRank, winningDetails.get(winningRank) + 1);
        }
        return winningDetails;
    }

    public static int compareNumbersWithWinningNumbers(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public static boolean compareNumbersWithBonusNumber(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        return numbers.contains(bonusNumber);
    }
}
