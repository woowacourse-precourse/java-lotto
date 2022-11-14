package lotto;

import java.util.ArrayList;
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

        List<Integer> check_duplicate = new ArrayList<Integer>();
        for (int number : numbers) {
            if (check_duplicate.contains(number)) {
                throw new IllegalArgumentException();
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }

            check_duplicate.add(number);
        }
    }

    public List<Integer> get_numbers() {
        return numbers;
    }
}
