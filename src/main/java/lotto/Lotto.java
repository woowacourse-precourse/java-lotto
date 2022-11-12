package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException();
            }

            check_duplicate.add(number);
        }
    }

    public List<Integer> get_numbers() {
        return numbers;
    }

    public List<Integer> sort() {
        List<Integer> temp_numbers = numbers;
        Collections.sort(temp_numbers);

        return temp_numbers;
    }
}
