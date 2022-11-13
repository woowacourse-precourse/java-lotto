package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import lotto.Constants.ERROR;
import lotto.Constants.REGEX;

public class Validator {
    public static void lottoFormat(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR.LOTTO_SIZE);
        }
        if (new HashSet<Integer>(numbers).size() != 6) {
            throw new IllegalArgumentException(ERROR.WINNING_NUMBER_DUPLICATE);
        }
    }

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


    public static void bonusNumber(String bonusNumber) {
        if (!Pattern.matches(REGEX.BONUS_NUMBER, bonusNumber)) {
            throw new IllegalArgumentException(ERROR.BONUS_NUMBER_RANGE);
        }
        if (Lotto.getWinningNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ERROR.BONUS_NUMBER_IN_WINNING_NUMBER);
        }
    }
}
