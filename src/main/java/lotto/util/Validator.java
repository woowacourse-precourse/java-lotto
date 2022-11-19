package lotto.util;

import lotto.constants.LottoStandard;

import java.util.List;

public class Validator {

    public static boolean hasDuplicate(List<Integer> numbers) {
        long distinctSize = numbers.stream()
                .distinct()
                .count();
        return numbers.size() != distinctSize;
    }

    public static boolean hasDuplicate(List<Integer> winningNumbers, int bonus) {
        return winningNumbers.contains(bonus);
    }

    public static boolean checkRange(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i < LottoStandard.NUMBER_START.getValue()
                    || i > LottoStandard.NUMBER_END.getValue()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSize(List<Integer> numbers) {
        return numbers.size() != LottoStandard.SIZE.getValue();
    }


}
