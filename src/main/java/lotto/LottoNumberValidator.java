package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Constant.LottoValue;

public class LottoNumberValidator {
    private static final List<Integer> range = IntStream
            .rangeClosed(LottoValue.MIN_RANGE, LottoValue.MAX_RANGE)
            .boxed()
            .collect(Collectors.toList());

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
        if (numbers.size() != LottoValue.NUMBER_EA) {
            return true;
        }

        return false;
    }

    public static boolean isOutOfRange(List<Integer> numbers) {
        if (range.containsAll(numbers)) {
            return false;
        }

        return true;
    }

    public static boolean isOutOfRange(int bonusNumber) {
        if (range.contains(bonusNumber)) {
            return false;
        }

        return true;
    }
}
