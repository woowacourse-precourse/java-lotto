package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (Validator.hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR.getMessage());
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public String toString() {
        return numbers.stream().sorted().collect(Collectors.toList()).toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
