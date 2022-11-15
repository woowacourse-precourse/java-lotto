package lotto.utils;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class Validation {
    public static void checkNumberLength(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_COUNT) {
            System.out.println(ErrorMessage.LOTTO_NUMBER_LENGTH_ERROR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_LENGTH_ERROR.getMessage());
        }
    }

    public static void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER) {
                System.out.println(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
            }
        }
    }

    public static void checkDuplicatedNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) != Constant.LOTTO_NUMBER_DUPLICATED_LIMIT) {
                System.out.println(ErrorMessage.LOTTO_NUMBER_DUPLICATED_ERROR.getMessage());
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED_ERROR.getMessage());
            }
        }
    }

    public static void checkSplitLength(int length) {
        if (length != Constant.LOTTO_NUMBER_COUNT) {
            System.out.println(ErrorMessage.WINING_NUMBER_SPLIT_LENGTH_ERROR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.WINING_NUMBER_SPLIT_LENGTH_ERROR.getMessage());
        }
    }

    public static void checkBonusNumberLength(int length) {
        if (length != Constant.BONUS_NUMBER_COUNT) {
            System.out.println(ErrorMessage.BONUS_NUMBER_LENGTH_ERROR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_LENGTH_ERROR.getMessage());
        }
    }

    public static void checkTypeNumber(String amount) {
        for (int i = 0; i < amount.length(); i++) {
            if (!Character.isDigit(amount.charAt(i))) {
                System.out.println(ErrorMessage.PURCHASE_AMOUNT_TYPE_ERROR.getMessage());
                throw new IllegalArgumentException(String.format(ErrorMessage.PURCHASE_AMOUNT_TYPE_ERROR.getMessage()));
            }
        }
    }
}
