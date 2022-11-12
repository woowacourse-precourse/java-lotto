package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Constant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
