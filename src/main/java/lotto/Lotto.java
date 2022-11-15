package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_LENGTH_IS_SIX.getMsg());
        }
    }

    public static void validateNumberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(WINNING_NUMBERS_RANGE.getMsg());
        }
    }
    private void validateLottoRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateNumberRange(num);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> numberDistinct = new HashSet<>(numbers);
        if (numberDistinct.size() != numbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_ARE_DUPLICATED.getMsg());
        }
    }
    public List<Integer> getLottoNumber() {
        return numbers;
    }
}
