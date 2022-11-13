package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sort();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
    }

    public void sort() {
        Collections.sort(numbers);
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
