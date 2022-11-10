package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.constant.LottoStatistic;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoStatistic.NUMBER_OF_LOTTERY_NUMBERS.getValue()) {
            throw new IllegalArgumentException();
        }
        Set<Integer> numbersWithoutDuplicate = new HashSet<>(numbers);
        if (numbersWithoutDuplicate.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public String getNumbersAsString() {
        return numbers.toString();
    }
}
