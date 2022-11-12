package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Comparator {

    public int getMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        long matchCount = lotto.getNumbers().stream()
                .filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .count();
        return Long.valueOf(matchCount).intValue();
    }

    public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
