package lotto;

import java.util.List;

public class LottoNumberValidator {
    private static final int NUMBER_EA = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;


    public static boolean existDuplicate(List<Integer> numbers) {
        int numbersTypeCount = (int)numbers
                .stream()
                .distinct()
                .count();

        if (numbersTypeCount != numbers.size()) {
            return true;
        }

        return false;
    }

    public static boolean isNotSameSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_EA) {
            return true;
        }

        return false;
    }

    public static boolean isOutOfRange(List<Integer> numbers) {
        IntStream range = IntStream.rangeClosed(MIN_RANGE, MAX_RANGE);
        if (numbers.contains(range)) {
            return true;
        }
        return false;
    }
}
