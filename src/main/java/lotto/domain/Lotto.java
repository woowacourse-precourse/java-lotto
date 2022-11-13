package lotto.domain;

import java.util.List;

public class Lotto {
    private static final Integer PRICE = 1000;
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

    public boolean isContain(Integer number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    public static Integer getPrice() {
        return PRICE;
    }
}
