package lotto.Model;

import java.util.Collections;
import java.util.List;
import lotto.Constant.Message;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR_SIZE.getMessage());
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
