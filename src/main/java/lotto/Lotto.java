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

    public String toString() {
        String sentence= "[";

        for (int i = 0; i < numbers.size() - 1; i++) {
            sentence += numbers.get(i) + ", ";
        }

        sentence += numbers.get(5);
        sentence += "]";

        return sentence;
    }
}
