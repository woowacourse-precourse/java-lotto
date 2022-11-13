package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    private static final String NUMBERS_SIZE_IS_NOT_SIX = "로또의 번호가 6개가 아닙니다.";
    private static final String NUMBERS_IS_NOT_IN_RANGE = "로또의 번호 중 1부터 45까지의 범위 밖의 숫자가 포함되었습니다.";
    private static final String DUPLICATE_NUMBERS_EXIST = "로또의 번호 중 중복된 숫자가 포함되었습니다.";
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_TOTAL_COUNT = 6;

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_TOTAL_COUNT) {
            throw new IllegalArgumentException(NUMBERS_SIZE_IS_NOT_SIX);
        }
        if (!checkNumbersRange(numbers)) {
            throw new IllegalArgumentException(NUMBERS_IS_NOT_IN_RANGE);
        }
        if (checkDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXIST);
        }
    }

    private static boolean checkNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            return true;
        }
        return false;
    }
}
