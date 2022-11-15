package domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        validateRangeOver(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 잘못된 로또 번호입니다.");
        }
    }

    public void validateOverlap(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 잘못된 로또 번호입니다.");
            throw new IllegalArgumentException();
        }
    }
    public void validateRangeOver(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 잘못된 로또 번호입니다.");
            }
        }
    }
}
