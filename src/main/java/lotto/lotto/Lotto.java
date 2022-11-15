package lotto.lotto;

import java.util.List;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.IllegalLottoLengthException;
import lotto.exception.IllegalLottoNumberRangeException;

public class Lotto {
    public static final int LOTTO_MAX_SIZE = 6;
    public static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    public static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    public static final int LOTTO_MAX_DUPLICATED_COUNT = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_MAX_SIZE) {
            throw new IllegalLottoLengthException();
        }
        boolean outOfRange = numbers.stream()
                .anyMatch(number -> number > LOTTO_NUMBER_UPPER_BOUND || number < LOTTO_NUMBER_LOWER_BOUND);
        if (outOfRange) {
            throw new IllegalLottoNumberRangeException();
        }
        boolean duplicated = numbers.stream()
                .anyMatch(number -> numbers.stream().filter(number::equals).count() > LOTTO_MAX_DUPLICATED_COUNT);
        if (duplicated) {
            throw new DuplicatedLottoNumberException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
