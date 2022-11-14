package lotto.utils;

import lotto.model.LottoStatus;
import java.util.HashMap;
import java.util.List;

import static lotto.model.ErrorMessage.*;
import static lotto.model.LottoStatus.*;

public class Validator {

    public void validatePurchasingAmountSize(String input) {
        if (input.length() < LottoStatus.PRICE.getDigitsSize()) {
            throw new IllegalArgumentException(INCORRECT_PURCHASING_AMOUNT.toString());
        }
    }

    public void validatePurchasingAmountNumber(String input) {
        validateFirstDigit(input);
        validateOtherDigit(input);
    }

    private void validateOtherDigit(String input) {
        for (int index = 1; index < input.length(); index++) {
            if (!Character.isDigit(getDigit(input, index))) {
                throw new IllegalArgumentException(INCORRECT_PURCHASING_AMOUNT.toString());
            }
        }
    }

    private void validateFirstDigit(String input) {
        char first = getDigit(input, 0);
        if (first == '0' || !Character.isDigit(first)) {
            throw new IllegalArgumentException(INCORRECT_PURCHASING_AMOUNT.toString());
        }
    }

    private char getDigit(String input, int index) {
        return input.charAt(index);
    }

    public void validateMonetaryUnit(String input) {
        if (!isMonetaryUnit(input)) {
            throw new IllegalArgumentException(INCORRECT_PURCHASING_AMOUNT.toString());
        }
    }

    private boolean isMonetaryUnit(String input) {
        return Integer.parseInt(input) % LottoStatus.PRICE.getValue() == 0;
    }

    public void validateLuckyNumberSize(String input) {
        String[] numbers = getNumbers(input);
        checkNumbersSize(numbers);
        checkNumberSize(numbers);
    }

    private void checkNumberSize(String[] numbers) {
        for (String number : numbers) {
            if (number.length() > END.getDigitsSize()) {
                throw new IllegalArgumentException(INCORRECT_LUCKY_NUMBER_SIZE.toString());
            }
        }
    }

    private void checkNumbersSize(String[] numbers) {
        if (numbers.length != SIZE.getValue()) {
            throw new IllegalArgumentException(INCORRECT_LUCKY_NUMBER_SIZE.toString());
        }
    }

    private String[] getNumbers(String input) {
        return input.split(",");
    }

    public void validateLuckyNumberDigit(String input) {
        for (String number : getNumbers(input)) {
            checkNumber(number);
        }
    }

    private void checkNumber(String number) {
        for (int index = 0; index < number.length(); index++) {
            if (!Character.isDigit(getDigit(number, index))) {
                throw new IllegalArgumentException(INCORRECT_LUCKY_NUMBER_DIGIT.toString());
            }
        }
    }

    public void validateLuckyNumberRange(String input) {
        for (String number : getNumbers(input)) {
            int luckyNumber = Integer.parseInt(number);
            if (luckyNumber < START.getValue() || luckyNumber > END.getValue()) {
                throw new IllegalArgumentException(INCORRECT_LUCKY_NUMBER_RANGE.toString());
            }
        }
    }

    public void validateLuckyNumberDuplication(String input) {
        HashMap<Integer, Integer> exist = new HashMap<>();
        addExist(input, exist);
        checkExist(input, exist);
    }

    private void checkExist(String input, HashMap<Integer, Integer> exist) {
        for (String number : getNumbers(input)) {
            int luckyNumber = Integer.parseInt(number);
            if (exist.get(luckyNumber) > LottoStatus.LIMIT.getValue()) {
                throw new IllegalArgumentException(LUCKY_NUMBER_DUPLICATION.toString());
            }
        }
    }

    private void addExist(String input, HashMap<Integer, Integer> exist) {
        for (String number : getNumbers(input)) {
            int luckyNumber = Integer.parseInt(number);
            exist.put(luckyNumber, exist.getOrDefault(luckyNumber, 0) + 1);
        }
    }

    public void validateBonusNumberSize(String input) {
        if (input.length() < START.getDigitsSize() || input.length() > END.getDigitsSize()) {
            throw new IllegalArgumentException(INCORRECT_BONUS_NUMBER_SIZE.toString());
        }
    }

    public void validateBonusNumberDigit(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (!Character.isDigit(getDigit(input, index))) {
                throw new IllegalArgumentException(INCORRECT_BONUS_NUMBER_DIGIT.toString());
            }
        }
    }

    public void validateBonusNumberRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < START.getValue() || bonusNumber > END.getValue()) {
            throw new IllegalArgumentException(INCORRECT_BONUS_NUMBER_RANGE.toString());
        }
    }

    public void validateDuplication(List<Integer> luckyNumber, String input) {
        if (luckyNumber.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION.toString());
        }
    }
}
