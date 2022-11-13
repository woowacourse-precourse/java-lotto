package lotto;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    public static final int MIN_WINNING_NUMBER = 1;
    public static final int MAX_WINNING_NUMBER = 45;
    private static final int WINNING_NUMBER_SIZE = 6;


    public void checkPurchaseInput(String str) {
        if (!isNumberFormat(str)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_FORMAT.getErrorMsg());
        }

        if (!isValidPurchaseCost(str)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_PURCHASE_COST.getErrorMsg());
        }
    }
    public void checkWinningNumberInput(String numbers) {
        String[] winningNumbers = numbers.split(",");

        if (!isValidLength(winningNumbers)){
            throw new IllegalArgumentException(ExceptionType.INVALID_LENGTH.getErrorMsg());
        }

        if (haveDuplicatedNumber(winningNumbers)) {
            throw new IllegalArgumentException(ExceptionType.DUPLICATED_NUMBER.getErrorMsg());
        }

        for (String winningNumber : winningNumbers) {
            if (!isNumberFormat(winningNumber)) {
                throw new IllegalArgumentException(ExceptionType.INVALID_FORMAT.getErrorMsg());
            }

            if (!isValidNumberRange(winningNumber)) {
                throw new IllegalArgumentException(ExceptionType.INVALID_RANGE.getErrorMsg());
            }
        }
    }

    public void checkBonusNumberInput(String str) {
        if (!isNumberFormat(str)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_FORMAT.getErrorMsg());
        }

        if (!isValidNumberRange(str)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_RANGE.getErrorMsg());
        }
    }

    private boolean isNumberFormat(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    private boolean isValidPurchaseCost(String str) {
        int cost = Integer.parseInt(str);

        return (cost % 1000) == 0;
    }

    private boolean isValidLength(String[] str) {
        return str.length == WINNING_NUMBER_SIZE;
    }

    private boolean haveDuplicatedNumber(String[] winningNumbers) {
        Set<String> storedNumbers = new HashSet<>();

        for (String winningNumber : winningNumbers) {
            if (storedNumbers.contains(winningNumber)) {
                return true;
            }

            storedNumbers.add(winningNumber);
        }

        return true;
    }

    private boolean isValidNumberRange(String str) {
        int number = Integer.parseInt(str);

        return MIN_WINNING_NUMBER <= number && number <= MAX_WINNING_NUMBER;
    }

}
