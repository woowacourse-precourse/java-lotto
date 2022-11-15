package lotto.exception;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.exception.ErrorMessage.*;

public class InputException extends IllegalArgumentException {

    private static final int NUMBERS_SIZE = 6;

    public void notDigitException(String inputString) {
        if (inputString.chars().allMatch(Character::isDigit)) {
            return;
        }
        throw new IllegalArgumentException(NOT_DIGIT.getMessage());
    }

    public void notThousandMoneys(int money) {
        if (money % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException(NOT_THOUSAND_MONEY.getMessage());
    }

    public void invalidNumbers(String inputNumbers) {
        int count = 0;
        Pattern pattern = Pattern.compile("(\\d{1,2})(,+)?");
        Matcher matcher = pattern.matcher(inputNumbers);
        while (matcher.find()) {
            count++;
            if (count == NUMBERS_SIZE && matcher.find()) {
                throw new IllegalArgumentException(INVALID_NUMBERS_INPUT.getMessage());
            } else if (count == NUMBERS_SIZE) {
                break;
            }
            if (matcher.group(2) == null) {
                throw new IllegalArgumentException(INVALID_NUMBERS_INPUT.getMessage());
            }
        }
    }

    public void duplicateNumberException(List<Integer> numbers) {
        boolean[] checkNumbers = new boolean[46];
        for (Integer number : numbers) {
            if (checkNumbers[number]) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
            }
            checkNumbers[number] = true;
        }
    }

    public void duplicateBonusNumberException(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public void numbersRangeException(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException(NOT_RANGE.getMessage());
            }
        }
    }
}
