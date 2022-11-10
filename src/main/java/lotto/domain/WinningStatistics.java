package lotto.domain;

import java.util.List;

public class WinningStatistics {

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
