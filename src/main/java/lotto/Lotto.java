package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Message.ERROR_INPUT_SIX.printError();
            throw new IllegalArgumentException();
        }
        validateLottoRange(numbers);
        validateLottoDuplicate(numbers);
    }

    private void validateLottoRange(List<Integer> numbers) {
        long count = numbers.stream().filter(s -> s > 45 || s < 1).count();
        if (count != 0) {
            Message.ERROR_INPUT_RANGE.printError();
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoDuplicate(List<Integer> result) {
        long count = result.stream().distinct().count();
        if (count != result.size()) {
            Message.ERROR_INPUT_DUPLICATE.printError();
            throw new IllegalArgumentException();
        }
    }
}
