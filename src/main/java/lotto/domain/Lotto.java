package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또는 6자리의 숫자로 입력되야 합니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또는 중복되지 않은 숫자로 이루어져야 합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            new LottoNumber(number);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }
}
