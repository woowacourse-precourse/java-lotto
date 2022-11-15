package lotto.domain;

import lotto.status.NumberStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberStatus.TOTAL_NUMBER_OF_LOTTO.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumber = new HashSet<>();
        for (Integer number : numbers) {
            checkNumber.add(number);
        }
        if (checkNumber.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
