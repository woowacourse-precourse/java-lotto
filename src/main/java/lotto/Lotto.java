package lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static lotto.config.Constants.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
        sortNumbers(numbers);

        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (!numbers.stream().allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(n -> n >= LOTTO_NUMBER_START_INCLUSIVE && n <= LOTTO_NUMBER_END_INCLUSIVE)) {
            throw new IllegalArgumentException();
        }
    }

    public void sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

}
