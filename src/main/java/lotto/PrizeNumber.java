package lotto;

import java.util.List;

import static lotto.Constants.*;
import static lotto.message.ExceptionMessage.*;

public class PrizeNumber {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public PrizeNumber(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        sizeValidate(numbers);
        duplicateValidate(numbers);
        numbersRangeValidate(numbers);
        bonusNumberRangeValidate(bonusNumber);
        duplicateBonusNumber(numbers, bonusNumber);
    }

    private void sizeValidate(List<Integer> numbers) {
        if (!isSizeEq(numbers)) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }

    private boolean isSizeEq(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_COUNT;
    }

    private void duplicateValidate(List<Integer> numbers) {
        if (isDuplicateExist(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    private boolean isDuplicateExist(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private void numbersRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
            }
        }
    }

    private void bonusNumberRangeValidate(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }

    private boolean isOutOfRange(int number) {
        return !(NUMBER_MIN_RANGE <= number && number <= NUMBER_MAX_RANGE);
    }

    private void duplicateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }
}
