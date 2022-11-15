package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.Validator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        for (Integer number: numbers) {
            checkNotValidNumber(number);
        }

        checkIncludingDuplicatedNumber(numbers);

        checkNumbersCount(numbers.size());
    }

    // TODO: 추가 기능 구현
    public String toString() {
        return numbers.stream().sorted().collect(Collectors.toList()).toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
