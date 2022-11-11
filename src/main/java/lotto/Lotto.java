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
            throw new IllegalArgumentException();
        }
    }

    boolean hasNumber(int bonus) {
        return numbers.contains(bonus);
    }

    int countMatchedNumber(Lotto winningLotto) {
        return (int) this.numbers.stream()
                .filter(winningLotto::hasNumber)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
