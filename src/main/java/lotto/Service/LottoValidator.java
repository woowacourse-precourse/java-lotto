package lotto.Service;

import lotto.Model.ValidNumbers;

import java.util.List;

public class LottoValidator {

    private static final int MAX_LOTTO_SIZE = ValidNumbers.MAX_LOTTO_SIZE.getValue();
    private static final int MIN_LOTTO_RANGE = ValidNumbers.MIN_LOTTO_RANGE.getValue();
    private static final int MAX_LOTTO_RANGE = ValidNumbers.MAX_LOTTO_RANGE.getValue();

    private static final String ERROR_HEADER = "[ERROR]";
    private static final String SIZE_ERROR_MESSAGE = ERROR_HEADER + " 6개의 숫자만 입력해주십시오.";
    private static final String DUPLICATION_ERROR_MESSAGE = ERROR_HEADER + " 중복되는 숫자는 입력할 수 없습니다.";
    private static final String RANGE_ERROR_MESSAGE = ERROR_HEADER + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public void validate(List<Integer> numbers) {
        checkLottoSize(numbers);
        checkDuplicate(numbers);
        countInvalidNumber(numbers);
    }

    public void validate(List<Integer> numbers, int bonusNumber) {
        validate(numbers);

        if (bonusNumber > MAX_LOTTO_RANGE || bonusNumber < MIN_LOTTO_RANGE) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    public void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public void checkDuplicate(List<Integer> numbers) {
        boolean isDuplicated = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (isDuplicated) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    public void countInvalidNumber(List<Integer> numbers) {
        long invalidCount = numbers.stream()
                .filter(num -> (num < MIN_LOTTO_RANGE || num > MAX_LOTTO_RANGE))
                .count();

        if (invalidCount > 0) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}
