package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.ExceptionConstants.*;
import static lotto.constant.LottoConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBER_LENGTH_EXCEPTION.toString());
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
