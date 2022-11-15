package lotto.lotto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoCompare {

    public int getCompareCount(List<Integer> numbers, List<Integer> winNumbers) {
        return numbers.stream()
                .filter(number -> winNumbers
                        .stream()
                        .anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList())
                .size();
    }

    public boolean getBonusCheck(int number, List<Integer> numbers) {
        return numbers.contains(number);
    }

}
