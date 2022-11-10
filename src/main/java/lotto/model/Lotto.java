package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private static final int CORRECT_NUMBERS_SIZE = 6;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String NUMBERS_SIZE_NOT_SIX_EXCEPTION_MESSAGE = "발행 로또 번호의 개수는 6개여야합니다.";
    private static final String NUMBERS_DUPLICATE_EXCEPTION_MESSAGE = "발행 로또 번호는 중복될 수 없습니다.";
    private static final String NUMBERS_WRONG_RANGE_EXCEPTION_MESSAGE = "발행 로또 번호는 1~45의 범위여야합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = ascendingSortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isNumbersSizeNotSix(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + NUMBERS_SIZE_NOT_SIX_EXCEPTION_MESSAGE);
        }
        if (isNumbersDuplicate(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }
        if (isNumbersWrongRange(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + NUMBERS_WRONG_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNumbersSizeNotSix(List<Integer> numbers) {
        return numbers.size() != CORRECT_NUMBERS_SIZE;
    }

    private boolean isNumbersDuplicate(List<Integer> numbers) {
        long numbersDistinctSize = numbers.stream()
                .distinct().count();
        return numbersDistinctSize != CORRECT_NUMBERS_SIZE;
    }

    private boolean isNumbersWrongRange(List<Integer> numbers) {
        long correntNumbersRangeCount = numbers.stream()
                .filter(number -> number >= 1 && number <= 45)
                .count();
        return correntNumbersRangeCount != CORRECT_NUMBERS_SIZE;
    }

    private List<Integer> ascendingSortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
