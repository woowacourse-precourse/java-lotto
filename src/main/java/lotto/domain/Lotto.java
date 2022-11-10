package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 번호의 유효성을 확인하는 클래스
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidateDuplicated(numbers);
        isValidateNumbersLength(numbers);
        isValidateNumbersRange(numbers);
    }

    private void isValidateDuplicated(List<Integer> numbers) {
        Set<Integer> checkDuplicated = new HashSet<>();

        for (int number : numbers) {
            checkDuplicated.add(number);
        }

        if (checkDuplicated.size() != Number.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != Number.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidateNumbersRange(List<Integer> numbers) {
        Collections.sort(numbers);
        if (numbers.get(0) < Number.LOTTO_NUMBER_MIN || numbers.get(Number.LOTTO_NUMBER_LENGTH - 1) > Number.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException();
        }
    }
}
