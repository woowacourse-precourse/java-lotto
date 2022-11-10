package lotto;

import java.util.List;

import validate.Check;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Check.numberSize(numbers);
        this.numbers = numbers;
    }

}
