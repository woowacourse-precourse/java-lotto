package lotto.lotto;

import lotto.ui.InputViewValidation;

import java.util.HashSet;
import java.util.List;

public class LottoValidation {

    public static void validateUniqueNumbers(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LottoManager.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(InputViewValidation.ERROR_DUPLICATE_NUMBER);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoManager.LOTTO_RANGE_START || number > LottoManager.LOTTO_RANGE_END) {
                throw new IllegalArgumentException(InputViewValidation.ERROR_LOTTO_NUMBER_RANGE);
            }
        }
    }

    public static void validateUniqueWinningNumbersWithBonus(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(InputViewValidation.ERROR_DUPLICATE_NUMBER);
        }
    }

}
