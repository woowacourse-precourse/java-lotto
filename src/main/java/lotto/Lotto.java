package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.Constants.LOTTO_SIZE;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
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
}
