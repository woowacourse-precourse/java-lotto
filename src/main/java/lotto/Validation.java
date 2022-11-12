package lotto;

import java.util.List;

public class Validation {
    public static void isValidUnit(int amount) throws IllegalArgumentException {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.INVALID_AMOUNT_UNIT);
        }
    }

    public static void isValidRange(int amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.LOTTO_OUT_OF_RANGE);
        }
    }

    public static void existOnlyNumber(String amount) throws IllegalArgumentException {
        try {
            Integer.parseInt(amount);;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.CANNOT_CONVERT_NUMBER);
        }
    }

    public static void checkWinningNumbersDuplication(List<String> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATE_NUMBER);
        }
    }

    public static void checkBonusNumberDuplication(List<Integer> winningNumbers, String bonusNumberInput) throws IllegalArgumentException {
        if (winningNumbers.contains(Integer.parseInt(bonusNumberInput))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATE_NUMBER);
        }
    }
}
