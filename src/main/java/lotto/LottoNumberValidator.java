package lotto;

import static lotto.Constant.LottoValue.MAX_RANGE;
import static lotto.Constant.LottoValue.MIN_RANGE;
import static lotto.Constant.LottoValue.NUMBER_EA;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class LottoNumberValidator {
    private static final List<Integer> RANGE = IntStream
            .rangeClosed(MIN_RANGE, MAX_RANGE)
            .boxed()
            .collect(Collectors.toList());


    public static boolean existDuplicate(List<Integer> numbers) {
        int numbersTypeCount = (int) numbers.stream().distinct().count();

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
        if (RANGE.containsAll(numbers)) {
            return false;
        }

        return true;
    }

    public static boolean isOutOfRange(int bonusNumber) {
        if (RANGE.contains(bonusNumber)) {
            return false;
        }

        return true;
    }
}
