package lotto.model;

import java.util.List;
import lotto.constants.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSixDigits(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSixDigits(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_DIGITS);
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
