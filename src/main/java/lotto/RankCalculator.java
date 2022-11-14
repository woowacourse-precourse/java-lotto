package lotto;

import java.util.List;

public class RankCalculator {

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
