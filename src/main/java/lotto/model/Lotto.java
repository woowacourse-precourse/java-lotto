package lotto.model;

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

    public int draw(List<Integer> answer, int bonus) {
        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}