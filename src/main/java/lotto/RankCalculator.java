package lotto;

import java.util.List;

public class RankCalculator {

    public Rank calculate(List<Integer> numbers, List<Integer> lotto, int bonusNumber) {
        int count = countMatchingNumber(numbers, lotto);
        return Rank.of(count, haveBonusNumber(numbers, count, bonusNumber));
    }

    private int countMatchingNumber(List<Integer> numbers, List<Integer> lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    private boolean haveBonusNumber(List<Integer> numbers, int count, int bonusNumber) {
        if (count == 5) {
            return numbers.contains(bonusNumber);
        }
        return false;
    }
}
