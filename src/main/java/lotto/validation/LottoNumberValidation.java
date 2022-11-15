package lotto.validation;

import lotto.exception.ErrorCode;

import java.util.List;

public class LottoNumberValidation {

    private List<Integer> numbers;

    public LottoNumberValidation(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    private void validate() {
        numberCountValid();
        duplicateValid();
        numberRangeValid();
    }

    private void numberCountValid() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private void duplicateValid() {
        int currentCount = numbers.size();
        int distinctCount = (int) numbers.stream().distinct().count();

        if (currentCount != distinctCount) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private void numberRangeValid() {
        if (!isNumberRange()) {
            throw new IllegalArgumentException(ErrorCode.ERROR.getMessage());
        }
    }

    private boolean isNumberRange() {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }
}
