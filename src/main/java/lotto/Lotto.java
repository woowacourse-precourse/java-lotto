package lotto;

import java.util.List;

import lotto.system.holder.ValidationHolder;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        ValidationHolder.validate(numbers, Lotto.class);
        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
