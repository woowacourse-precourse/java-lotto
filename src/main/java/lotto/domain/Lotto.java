package lotto.domain;

import static lotto.ui.ConsoleMessage.INVALID_LOTTO_SIZE;
import static lotto.ui.ConsoleMessage.LOTTO_NUMBER_DUPLICATE;
import static lotto.ui.ConsoleMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.ui.LottoConsole.printErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers.size());
        validateNumbersInRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(int size) {
        if (size != LOTTO_NUMBERS_SIZE) {
            printErrorMessage(INVALID_LOTTO_SIZE.toString());
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateSingleNumberInRange(number);
        }
    }

    private void validateSingleNumberInRange(Integer number) {
        if (START_NUMBER > number || number > END_NUMBER) {
            printErrorMessage(LOTTO_NUMBER_OUT_OF_RANGE.toString());
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            printErrorMessage(LOTTO_NUMBER_DUPLICATE.toString());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
