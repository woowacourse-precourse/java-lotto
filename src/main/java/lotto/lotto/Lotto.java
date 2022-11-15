package lotto.lotto;

import java.util.List;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.IllegalLottoLengthException;
import lotto.exception.IllegalLottoNumberRangeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalLottoLengthException();
        }
        boolean outOfRange = numbers.stream().anyMatch(number -> number > 45 || number < 1);
        if (outOfRange) {
            throw new IllegalLottoNumberRangeException();
        }
        boolean duplicated = numbers.stream()
                .anyMatch(number -> numbers.stream().filter(number::equals).count() > 1);
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
