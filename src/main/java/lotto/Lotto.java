package lotto;

import java.util.ArrayList;
import java.util.Comparator;
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
        checkDuplicatedNumber(numbers);
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        numbers.forEach(number -> {
            if (list.contains(number)) {
                throw new IllegalArgumentException();
            }
            list.add(number);
        });
    }

    public List<Integer> getNumbers() {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
