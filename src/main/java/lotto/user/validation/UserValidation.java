package lotto.user.validation;

import java.util.HashSet;
import java.util.List;
import lotto.domain.LottoEnum;
import lotto.user.UserUtil;

public class UserValidation {
    private static final int AMOUNT_UNITS = 1000;
    private static final int REMAINDER_ZERO = 0;
    private static final String INPUT_NUMBERS_REGEXP = "^([1-9]+,)+[1-9]+$";

    public static void validate(String userAmount) {
        validateUnits(userAmount);
    }

    public static void validateNumbers(String userInput) {
        validateInputFormat(userInput);
        validateNumberRange(userInput);
        validateNoDuplicateNumbers(userInput);
    }

    private static void validateInputFormat(String uerInput) {
        if (!uerInput.matches(INPUT_NUMBERS_REGEXP)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_FORMAT.toString());
        }
    }

    private static void validateNumberRange(String userInput) {
        List<Integer> userNumbers = UserUtil.convertUserInputToNumbers(userInput);
        boolean correctNumber = userNumbers.stream().allMatch(LottoEnum::isNumberInRange);
        if (!correctNumber) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE.toString());
        }
    }

    private static void validateUnits(String userAmount) {
        if ((Integer.parseInt(userAmount) % AMOUNT_UNITS) != REMAINDER_ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.UNITS.toString());
        }
    }

    private static void validateNoDuplicateNumbers(String userInput) {
        List<Integer> userNumbers = UserUtil.convertUserInputToNumbers(userInput);
        HashSet<Integer> numberAppeared = new HashSet<>();
        for (Integer number : userNumbers) {
            checkDuplicateNumber(number, numberAppeared);
        }
    }

    private static void checkDuplicateNumber(Integer number, HashSet<Integer> numberAppeared) {
        if (numberAppeared.contains(number)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER.toString());
        }
        numberAppeared.add(number);
    }
}
