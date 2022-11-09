package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int CORRECT_NUMBERS_SIZE = 6;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] : ";
    private static final String NUMBERS_SIZE_NOT_SIX_EXCEPTION_MESSAGE = "발행 로또 번호의 개수는 6개여야합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNumbersSizeNotSix(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + NUMBERS_SIZE_NOT_SIX_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNumbersSizeNotSix(List<Integer> numbers) {
        return numbers.size() != CORRECT_NUMBERS_SIZE;
    }
}
