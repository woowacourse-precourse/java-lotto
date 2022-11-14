package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {

    public static void validateOverlap(List<Integer> numbers) {
        HashSet<Integer> appeared = new HashSet<>();
        for (int number : numbers) {
            if (appeared.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED_ERROR);
            }
            appeared.add(number);
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
            }
        }
    }
}
