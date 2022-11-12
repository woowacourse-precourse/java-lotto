package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateRepeat(numbers);
        validateOver(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 개수는 6개여야 합니다.");
        }
    }

    private void validateRepeat(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (Collections.frequency(numbers, numbers.get(i)) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복이 되어선 안됩니다.");
            }
        }
    }

    private void validateOver(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 && numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자는 1부터 46까지의 수 중 하나입니다");
            }
        }
    }
}
