package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호의 개수는 6개이어야 합니다.";
    private static final String DUPLICATES_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호에 1 ~ 45 범위를 벗어난 숫자가 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATES_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isNotValidRange(number)) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }

    private boolean isNotValidRange(int number) {
        return (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER));
    }
}
