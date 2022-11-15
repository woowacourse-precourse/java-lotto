package lotto.utils;

import java.util.Collections;
import java.util.List;

public class Validation {
    public static void checkNumberLength(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_LENGTH_ERROR);
        }
    }

    public static void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
            }
        }
    }

    public static void checkDuplicatedNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) != Constant.LOTTO_NUMBER_DUPLICATED_LIMIT) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED_ERROR);
            }
        }
    }

    public static void checkSplitLength(int length) {
        if (length != Constant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WINING_NUMBER_SPLIT_LENGTH_ERROR);
        }
    }

    public static void checkBonusNumberLength(int length) {
        if (length != Constant.BONUS_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_LENGTH_ERROR);
        }
    }
}
