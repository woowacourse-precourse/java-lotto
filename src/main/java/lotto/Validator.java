package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import lotto.Constants.ERROR;
import lotto.Constants.REGEX;
import lotto.domain.Lotto;

public class Validator {
    public static void payment(String paymentInput) {
        if (!Pattern.matches(REGEX.PAYMENT, paymentInput)) {
            throw new IllegalArgumentException(ERROR.PURCHASE_FORMAT);
        }
    }

    public static void winningNumberFormat(String inputWinningNumber) {
        if (!Pattern.matches(REGEX.WINNING_NUMBERS, inputWinningNumber)) {
            throw new IllegalArgumentException(ERROR.WINNING_NUMBER_FORMAT);
        }
    }

    public static void winningNumberDuplicate(Integer[] winningNumbers) {
        HashSet<Integer> removeDuplicatedNumbers = new HashSet<Integer>(List.of(winningNumbers));
        if (removeDuplicatedNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR.WINNING_NUMBER_DUPLICATE);
        }
    }

    public static void bonusNumberRange(String bonusNumber) {
        if (!Pattern.matches(REGEX.BONUS_NUMBER, bonusNumber)) {
            throw new IllegalArgumentException(ERROR.BONUS_NUMBER_RANGE);
        }
    }

    public static void bonusNumberInWinningNumbers(String bonusNumber) {
        if (Lotto.getWinningNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ERROR.BONUS_NUMBER_IN_WINNING_NUMBER);
        }
    }
}
