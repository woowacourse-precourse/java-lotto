package lotto.Model;

import java.util.Collections;
import java.util.List;
import lotto.Constant.Constants.Error;
import lotto.Constant.Constants.Number;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != Number.LIST_SIZE) {
            throw new IllegalArgumentException(Error.SIZE);
        }
        if (numbers.stream().distinct().count() != Number.LIST_SIZE) {
            throw new IllegalArgumentException(Error.DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
