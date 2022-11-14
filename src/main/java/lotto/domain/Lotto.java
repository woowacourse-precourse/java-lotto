package lotto.domain;

import java.util.*;

import static lotto.enums.Error.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sizeCheck(numbers);
        duplicationCheck(numbers);
        numberRangeCheck(numbers);
        this.numbers = numbers;
    }

    private static List<Integer> sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ER_NUMBER_LENGTH.getMessage());
        }
        return numbers;
    }

    private static List<Integer> numberRangeCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException(ER_NUMBER_RANGE.getMessage());
            }
        }
        return numbers;
    }

    private static List<Integer> duplicationCheck(List<Integer> numbers) {
        Set<Integer> duplicationTestSet = new HashSet<>(numbers);
        if (duplicationTestSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ER_DUPLICATION.getMessage());
        }
        return numbers;
    }


}
