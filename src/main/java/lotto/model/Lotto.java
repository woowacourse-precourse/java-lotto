package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NUMBER_IS_NOT_SIX = "로또가 6개보다 많거나 적은 수의 번호를 가진 채 발행됐습니다.";
    private static final String NUMBER_IS_DUPLICATED = "로또가 중복된 번호로 발행됐습니다.";
    private static final String NUMBER_IS_NOT_BETWEEN_1_AND_45 = "로또가 1에서 45의 범위를 벗어난 번호를 가진 채 발행됐습니다.";
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int CORRECT_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumber(numbers);
        validateBetween1And45(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != CORRECT_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX + NUMBER_IS_NOT_SIX);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinct_numbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbers.size() != distinct_numbers.size()) {
            throw new IllegalArgumentException(ERROR_PREFIX + NUMBER_IS_DUPLICATED);
        }
    }

    private void validateBetween1And45(List<Integer> numbers) {
        List<Integer> filter_numbers = numbers.stream()
                .filter(number -> number < START_NUMBER || number > END_NUMBER)
                .collect(Collectors.toList());
        if (!filter_numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + NUMBER_IS_NOT_BETWEEN_1_AND_45);
        }
    }
}
