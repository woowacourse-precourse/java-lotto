package lotto.util;

import java.util.List;

public class Validator {
    private static final int NUMBER_START = 1;
    private static final int NUMBER_END = 45;
    private static final int LOTTO_SIZE = 6;

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
            if (i < NUMBER_START || i > NUMBER_END) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }


}
