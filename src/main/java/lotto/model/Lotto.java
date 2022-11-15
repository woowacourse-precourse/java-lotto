package lotto.model;

import static lotto.util.Constants.NUMBER_COUNTS;
import static lotto.util.ErrorMessage.ERROR_LOTTO_DUPLICATES;
import static lotto.util.ErrorMessage.ERROR_LOTTO_SIZE;
import static lotto.util.Formatter.verifyRangeOfLottoNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNTS) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
        validateRangeOfNumbers(numbers);
        validateDuplicateNumbers(numbers);
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATES);
        }
    }

    private static void validateRangeOfNumbers(List<Integer> numbers) {
        for (Integer winningNumber : numbers) {
            verifyRangeOfLottoNumber(winningNumber);
        }
    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }

}
