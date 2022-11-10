package lotto.model;

import java.util.List;
import lotto.constants.ErrorMessage;

public class Lotto {

    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSixDigits(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSixDigits(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_DIGITS);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
                throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE);
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (isDuplicate(numbers, index)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE);
            }
        }
    }

    private static boolean isDuplicate(List<Integer> numbers, int index) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(index) == numbers.get(i)) {
                continue;
            }
            return true;
        }
        return false;
    }
}
