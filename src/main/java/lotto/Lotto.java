package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE_NUM = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_NUM) {
            throw new IllegalArgumentException();
        }
    }

    public ArrayList getNumbers() {
        return new ArrayList(numbers);
    }
}