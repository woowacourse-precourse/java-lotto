package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.resource.message.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ExceptionMessage.INVALID_NUMBER_COUNT.getMessage());
            throw new IllegalArgumentException();
        }
        if (Set.copyOf(numbers).size() != numbers.size()) {
            System.out.println(ExceptionMessage.DUPLICATE_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
