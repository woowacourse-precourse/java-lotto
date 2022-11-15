package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String EMPTY_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호가 등록되지 않았습니다.";
    private static final String NUMBERS_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호의 개수가 6개로 이루어져 있지 않습니다.";
    private static final String LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호 범위인 1 ~ 45에 속하지 않는 수가 입력되었습니다.";
    private static final String DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 수가 있습니다.";
    private static final int LIMIT_SIZE = 6;
    private static final int RANGE_FIRST_VALUE = 1;
    private static final int RANGE_LAST_VALUE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateEmptyNumber(numbers);

        validateNotNumberType(numbers);

        validateNumbersRange(numbers);

        validateDuplicateLottoNumber(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateEmptyNumber(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateNotNumberType(List<Integer> numbers) {
        if (numbers.size() != LIMIT_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < RANGE_FIRST_VALUE || number > RANGE_LAST_VALUE) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicateLottoNumber(List<Integer> numbers) {
        HashSet<Integer> numericalSeparator = new HashSet<>();

        for (Integer number : numbers) {
            if (!numericalSeparator.contains(number)) {
                numericalSeparator.add(number);
                continue;
            }

            if (numericalSeparator.contains(number)) {
                throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
