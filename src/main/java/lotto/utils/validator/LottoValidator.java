package lotto.utils.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.Exceptions.*;
import static lotto.utils.LottoInformation.*;

public class LottoValidator {
    public static void checkSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS.toString());
        }
    }

    public static void checkLottoNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            checkLottoNumber(number);
        }
    }

    public static void checkLottoNumber(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER.toString());
        }
    }

    public static void checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SELECTION_COUNT) {
            throw new IllegalArgumentException(EXIST_DUPLICATE_NUMBER.toString());
        }
    }

    public static void checkContainNumber(List<Integer> numbers, int target) {
        if (numbers.contains(target)) {
            throw new IllegalArgumentException(EXIST_DUPLICATE_NUMBER.toString());
        }
    }
}