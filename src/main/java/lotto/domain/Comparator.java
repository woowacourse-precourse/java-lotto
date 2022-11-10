package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Comparator {

    public int getMatchCount(List<Integer> userLotteryNumbers, List<Integer> winningNumbers) {
        long matchCount = userLotteryNumbers.stream()
                .filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .count();
        return Long.valueOf(matchCount).intValue();
    }

    public boolean hasBonusNumber(List<Integer> userLotteryNumbers, int bonusNumber) {
        return userLotteryNumbers.contains(bonusNumber);
    }
}
