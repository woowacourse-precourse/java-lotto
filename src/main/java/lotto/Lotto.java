package lotto;

import java.util.*;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.LENGTH_EXCEPTION_MESSAGE);
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (hasDuplicatedNumber(i, numbers.get(i), numbers)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_EXCEPTION_MESSAGE);
            }
        }

        if (checkWinNumberRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.RANGE_EXCEPTION_MESSAGE);
        }
    }

    /* 중복검사 */
    private boolean hasDuplicatedNumber(int indexNumber, int number, List<Integer> numbers) {
        for (int j = indexNumber + 1; j < numbers.size(); j++) {
            if (numbers.get(j) == number) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(1 <= number && number <= 45)) {
                return true;
            }
        }
        return false;
    }

    public void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (checkBonusNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.RANGE_EXCEPTION_MESSAGE);
        }

        if (hasDuplicatedLottoNumberWithBonusNumber(numbers, bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public boolean hasDuplicatedLottoNumberWithBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private boolean checkBonusNumberRange(int bonusNumber) {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            return true;
        }
        return false;
    }

}
