package lotto;

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
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchNumber(int pickedNumber){
        for (int j = 0; j < this.numbers.size(); j++) {
            if (this.numbers.get(j) == pickedNumber) {
                return 1;
            }
            if (this.numbers.get(j) > pickedNumber) {
                return 0;
            }
        }
        return 0;
    }
}
