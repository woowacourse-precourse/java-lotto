package lotto;

import java.util.List;

public class RankCalculator {

    private int countMatchingNumber(List<Integer> numbers, List<Integer> lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
