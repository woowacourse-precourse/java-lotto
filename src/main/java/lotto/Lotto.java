package lotto;

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
