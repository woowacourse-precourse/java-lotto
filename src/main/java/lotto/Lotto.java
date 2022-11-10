package lotto;

import lotto.exception.IllegalLottoException;
import lotto.exception.NotLottoValueException;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    private static final int MIN = 1;
    private static final int MAX = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numberSet = numbers.stream().collect(Collectors.toSet());
        for (Integer number : numberSet) {
            if (number < MIN || number > MAX)
                throw new NotLottoValueException();
        }
        if (numberSet.size() != 6)
            throw new IllegalLottoException();
    }
}
