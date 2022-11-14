package lotto;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean existsNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumber(List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (this.numbers.contains(number)) {
                count ++;
            }
        }
        return count;
    }
}
