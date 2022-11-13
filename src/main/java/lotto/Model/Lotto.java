package lotto.Model;

import java.util.Collections;
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
        Collections.sort(numbers);

        for (int i=1; i<numbers.size(); i++) {
            if (numbers.get(i - 1).equals(numbers.get(i))) {
                throw new IllegalArgumentException();
            }
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
