package lotto;

import static lottoMachine.enums.Messages.ERROR_MESSAGE_PREFIX;
import static lottoMachine.enums.Messages.LOTTO_NUMBER_COUNT_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX.toString() + LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != 6) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX.toString() + LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
