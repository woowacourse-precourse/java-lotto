package lotto.Util;

import lotto.domain.ErrorMessage;

import java.util.List;

public class Validation extends IllegalArgumentException{
    public static final int LOTTO_MONEY = 1000;
    public static final int LOTTO_NUMBER = 6;
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    public static void validateInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_ERROR.getMessage());
        }
    }

    public static void isStartWithZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_ERROR.getMessage());
        }
    }

    public static void validateAmount(int input) {
        if (input % LOTTO_MONEY != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_ERROR.getMessage());
        }
    }

    public static void validateNumbers(int input) {
        if(input != LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateRange(int number) {
        if(number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_ERROR.getMessage());
        }
    }

    public static void validateDuplication(List<Integer> winningNumber, int number) {
        if(winningNumber.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ERROR.getMessage());
        }
    }
}
