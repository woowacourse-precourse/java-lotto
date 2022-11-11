package lotto.vo;

import java.util.List;

import lotto.system.holder.ValidationHolder;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ValidationHolder.validate(numbers, Lotto.class);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
