package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int compare(Lotto compareLotto) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> numbers.contains(compareLotto.numbers.get(i))).count();
    }

    public boolean hasBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
