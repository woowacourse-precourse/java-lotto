package lotto.exception;

import lotto.enums.Message;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validateNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateNumber(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (LOTTO_START_NUMBER > number || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(Message.ERROR_NUMBER_RANGE.getMessage());
            }
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }
}
