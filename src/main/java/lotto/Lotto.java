package lotto;

import java.util.List;
import validation.Validator;

public class Lotto {
    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;
    public static final int SIZE = 6;
    public static final int BONUS_SIZE = 1;
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();

        validator.validateGeneratedNumbers(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
