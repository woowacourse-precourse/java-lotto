package lotto;

import java.util.HashSet;
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

        HashSet<Integer> toCompare = new HashSet<>(numbers);
        if(toCompare.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }

        for (Integer winningNumber : numbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
}
