package lotto.model;

import lotto.enums.ExceptionErrorType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicateNumber(numbers);
        checkRange(numbers);
    }
    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.LOTTO_SIZE_IS_6.getDescription()
            );
        }
    }
    private void checkDuplicateNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_NOT_DUPLICATE_NUMBER.getDescription()
            );
        }
    }
    private void checkRange(List<Integer> lottoNumbers) {
        if (Collections.min(lottoNumbers) < 1 || 45 < Collections.max(lottoNumbers)) {
            throw new IllegalArgumentException(
                    ExceptionErrorType.INPUT_NUMBER_BETWEEN_1_45.getDescription()
            );
        }
    }
}
