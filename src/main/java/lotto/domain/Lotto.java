package lotto.domain;

import static lotto.Validation.validateLotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public Integer compare(Lotto lotto) {
        return Math.toIntExact(lotto.numbers.stream()
            .filter(this.numbers::contains)
            .count());
    }

    public boolean compare(Integer bonus) {
        return this.numbers.contains(bonus);
    }
}
