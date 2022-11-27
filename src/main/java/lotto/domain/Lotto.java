package lotto.domain;

import java.util.*;

import static lotto.messages.ERR_MSG.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateHavingDuplicatedNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            raiseException(INVALID_LENGTH.getMsg());
        }
    }

    private void validateHavingDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        numbers.stream()
                .filter(x -> !set.contains(x))
                .forEach(set::add);
        if (set.size() != 6) {
            raiseException(INVALID_NUMBER_UNIQUE.getMsg());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream()
                .filter(x -> x < 1 || x > 45)
                .findAny()
                .ifPresent(x -> raiseException(ERR_NUMBER_RANGE.getMsg()));
    }

    private void raiseException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    public void printLotto() {
        System.out.println(numbers);
    }
}
