package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.domain.Preset.*;
import static lotto.view.OutputView.LOTTO_PRINT_FORMAT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkOutOfRange(numbers);
        checkDuplicated(numbers);
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return String.format(LOTTO_PRINT_FORMAT, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), numbers.get(4), numbers.get(5));
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int number) {
        return getNumbers().contains(number);
    }

    public static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE)
                throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
        }
    }

    public static void checkDuplicated(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1)
                throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
        }
    }
}
