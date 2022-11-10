package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        List<Integer> range = IntStream.rangeClosed(MIN_RANGE, MAX_RANGE)
                .boxed()
                .collect(Collectors.toList());

        if (range.containsAll(numbers)) {
            return false;
        }

        return true;
    }
}
