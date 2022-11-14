package lotto.ui;

import java.util.Set;
import lotto.Constants;
import lotto.LottoNumber;
import java.util.HashSet;
import java.util.List;

public class Validator {
    private void throwExceptionWithErrorMessage(String errorMessage) {
        throw new IllegalArgumentException("[ERROR] " + errorMessage);
    }

    public void throwIfEmtpy(String input) {
        if (input.isEmpty()) {
            throwExceptionWithErrorMessage(ErrorMessages.INPUT_IS_EMPTY.getMessage());
        }
    }

    public void throwIfNotNumber(String input) {
        if (!input.matches("\\d+")) {
            throwExceptionWithErrorMessage(ErrorMessages.INPUT_IS_NOT_NUBMER.getMessage());
        }
    }

    public void throwIfNotDividedByUnitPrice(Integer number) {
        if (number % Constants.LOTTO_PRICE.getNumber() != 0) {
            throwExceptionWithErrorMessage(String.format(ErrorMessages.INPUT_IS_NOT_DIVIDED_BY_UNIT_PRICE.getMessage(),
                    Constants.LOTTO_PRICE.getNumber()));
        }
    }

    public void throwIfNotInRange(Integer number) {
        if (number < Constants.MIN_LOTTO_NUMBER.getNumber() || number > Constants.MAX_LOTTO_NUMBER.getNumber()) {
            throwExceptionWithErrorMessage(String.format(ErrorMessages.INPUT_IS_NOT_IN_RANGE.getMessage(),
                    Constants.MIN_LOTTO_NUMBER.getNumber(), Constants.MAX_LOTTO_NUMBER.getNumber()));
        }
    }

    public void throwIfNotPositive(Integer number) {
        if (number <= 0) {
            throwExceptionWithErrorMessage(ErrorMessages.INPUT_IS_NOT_POSITIVE.getMessage());
        }
    }

    public void throwIfNotUnique(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throwExceptionWithErrorMessage(ErrorMessages.INPUT_IS_NOT_UNIQUE.getMessage());
        }
    }

    public void throwIfNotSix(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT.getNumber()) {
            throwExceptionWithErrorMessage(ErrorMessages.INPUT_IS_NOT_SIX.getMessage());
        }
    }

    public void throwIfAlreadyHasNumber(List<Integer> numbers, LottoNumber number) {
        if (numbers.contains(number.getNumber())) {
            throwExceptionWithErrorMessage(ErrorMessages.INPUT_IS_NOT_UNIQUE.getMessage());
        }
    }
}
