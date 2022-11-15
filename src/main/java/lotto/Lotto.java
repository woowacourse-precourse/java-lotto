package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        Validation validation = new Validation();
        validation.checkDuplicate(numbers);
        for (int number : numbers) {
            validation.checkNumberInRange(number);
        }
    }

    public boolean hasNumber(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public String numbersToString() {
        return numbers.toString();
    }

}
