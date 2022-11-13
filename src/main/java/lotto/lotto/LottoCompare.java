package lotto.lotto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoCompare {

    public int getCompareCount(List<Integer> numbers, List<Integer> playerNumbers) {
        return numbers.stream()
                .filter(number -> playerNumbers
                        .stream()
                        .anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList())
                .size();
    }

    public boolean getBonusCheck(int number, List<Integer> numbers) {
        return numbers.contains(numbers);
    }

}
