package lotto.domain;

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

    public String showNumbers() {
        String message = "[";
        for (int number : numbers) {
            message += number + ", ";
        }
        message = message.substring(0, message.length() - 2);
        message += "]";
        return message;
    }
}
