package lotto.model;

import java.util.List;

public class Lotto {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String LOTTO_NUMBER_SIZE_ERROR = "[ERROR] 로또 숫자의 개수가 6개가 아닙니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 숫자의 범위가 1~45사이가 아닙니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR = "[ERROR] 로또 숫자가 모두 다른 값을 가지지 않습니다.";


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR);
        }
        if (isNumbersNotInEffectiveRange(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    private boolean isNumbersNotInEffectiveRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        int sizeOfDistinctNumbers = (int)numbers.stream().distinct().count();

        if (sizeOfDistinctNumbers != LOTTO_NUMBERS_SIZE) {
            return true;
        }
        return false;
    }

    // TODO: 추가 기능 구현
}
