package lotto;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_SIX.printError());
        }
        validateLottoRange(numbers);
        validateLottoDuplicate(numbers);
    }

    private void validateLottoRange(List<Integer> numbers) {
        long count = numbers.stream().filter(s -> s > 45 || s < 1).count();
        if (count != 0) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_RANGE.printError());
        }
    }

    private void validateLottoDuplicate(List<Integer> result) {
        long count = result.stream().distinct().count();
        if (count != result.size()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_DUPLICATE.printError());
        }
    }

    public void compareLotto(List<Integer> lotteries, int bonus) {
        long count = 0;
        boolean isBonus = numbers.contains(bonus);
        for (int number : lotteries) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        Calculator.calculateLottos(count, isBonus);
    }
}
