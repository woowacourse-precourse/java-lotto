package lotto.domain;

import java.util.List;

import lotto.utils.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            Validator.listLengthCheck(numbers, 6);
            Validator.containDuplicate(numbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
