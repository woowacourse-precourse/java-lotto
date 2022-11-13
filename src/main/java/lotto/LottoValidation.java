package lotto;

import lotto.ui.InputViewValidation;

import java.util.HashSet;
import java.util.List;

public class LottoValidation {

    public static void validateUniqueNumbers(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException(InputViewValidation.ERROR_DUPLICATE_NUMBER);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(InputViewValidation.ERROR_LOTTO_NUMBER_RANGE);
            }
        }
    }

}
