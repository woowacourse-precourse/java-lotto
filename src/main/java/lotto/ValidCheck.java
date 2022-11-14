package lotto;

import lotto.enumeration.LottoErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class ValidCheck {
    public static void isPayUnit(int pay) {
        if (pay % 1000 != 0) {
            throw new IllegalArgumentException(LottoErrorMessage.UNIT_ERROR.getErrorMessage());
        }
    }

    public static void isComma(String readline) {
        if (readline.split(",").length != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.COMMA_ERROR.getErrorMessage());
        }
    }

    public static void isNumeric(String readline) {
        if (!Pattern.matches("^[1-9]\\d*$", readline)) {
            throw new IllegalArgumentException(LottoErrorMessage.NUMERIC_ERROR.getErrorMessage());
        }
    }

    public static void isNumeric(String[] readline) {
        if (!Pattern.matches("^[1-9]\\d*$", String.join("", readline))) {
            throw new IllegalArgumentException(LottoErrorMessage.NUMERIC_ERROR.getErrorMessage());
        }
    }

    public static void isDuplication(int bonusNumber, List<Integer> matchNumbers) {
        if (matchNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_WIN_AND_BONUS_ERROR.getErrorMessage());
        }
    }

    public static void isDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATION_ERROR.getErrorMessage());
        }
    }

    public static void isRange(List<Integer> winNumbers) {
        if (winNumbers.stream().anyMatch(winNumber -> winNumber < 1 || winNumber > 45)) {
            throw new IllegalArgumentException(LottoErrorMessage.RANGE_ERROR.getErrorMessage());
        }
    }

    public static void isRange(int winNumber) {
        if (winNumber < 1 || winNumber > 45) {
            throw new IllegalArgumentException(LottoErrorMessage.RANGE_ERROR.getErrorMessage());
        }
    }
}
