package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.constants.ErrorCode;

public class Lotto {

    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws Exception {
        validateSixDigits(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateSixDigits(List<Integer> numbers) throws Exception {
        if (numbers.size() != 6) {
            throw ErrorCode.NOT_SIX_DIGITS.getException();
        }
    }

    private void validateRange(List<Integer> numbers) throws Exception {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
                throw ErrorCode.NOT_IN_RANGE.getException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) throws Exception {
        for (int index = 0; index < numbers.size(); index++) {
            if (isDuplicate(numbers, index)) {
                throw ErrorCode.NOT_DUPLICATE.getException();
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
