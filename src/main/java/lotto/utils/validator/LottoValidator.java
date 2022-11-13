package lotto.utils.validator;

import lotto.utils.Error;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.LottoInformation.*;

public class LottoValidator {
    public static void checkLottoNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            checkLottoNumber(number);
        }
    }

    public static void checkLottoNumber(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            System.out.println(Error.NOT_LOTTO_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SELECTION_COUNT) {
            System.out.println(Error.EXIST_DUPLICATE_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    public static void checkContainNumber(List<Integer> numbers, int target) {
        if (numbers.contains(target)) {
            System.out.println(Error.EXIST_DUPLICATE_NUMBER);
            throw new IllegalArgumentException();
        }
    }
}
