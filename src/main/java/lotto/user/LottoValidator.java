package lotto.user;

import lotto.util.Validator;

import java.util.List;

public class LottoValidator extends Validator {
    public static boolean isNumbersNotRepeated(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .count() == numbers.size();
    }

    public static boolean isNumbersInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        return numbers
                .stream()
                .filter(number -> isIntegerInRange(number, startInclusive, endInclusive))
                .count() == numbers.size();
    }
}
