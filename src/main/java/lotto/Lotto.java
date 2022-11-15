package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_AMOUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }
}
