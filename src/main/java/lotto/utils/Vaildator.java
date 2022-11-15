package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Validator {
    public static void isMultiplesOfThousand(int inputNumber) {
        if (inputNumber % LottoInfo.PRICE.getNumber() != 0) {
            String message = String.format(ErrorMessages.PRICE_ERROR.getMessage(), LottoInfo.PRICE.getNumber());
            throw new IllegalArgumentException(message);
        }
    }

    public static void isUnderZero(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ErrorMessages.ZERO_ERROR.getMessage());
        }
    }

    public static void isInRange(int input) {
        if (LottoInfo.START_NUMBER.getNumber() > input
                || input > LottoInfo.END_NUMBER.getNumber()) {
            String message = String.format(ErrorMessages.RANGE_ERROR.getMessage(),
                    LottoInfo.START_NUMBER.getNumber(), LottoInfo.END_NUMBER.getNumber());
            throw new IllegalArgumentException(message);
        }
    }

    public static void containDuplicate(List<Integer> inputs) {
        Set<Integer> inputSet = new HashSet<>(inputs);
        if (inputSet.size() != inputs.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_ERROR.getMessage());
        }
    }

    public static void listLengthCheck(List<Integer> inputs, int length) {
        if (inputs.size() != length) {
            String message = String.format(ErrorMessages.LENGTH_ERROR.getMessage(), length);
            throw new IllegalArgumentException(message);
        }
    }
}