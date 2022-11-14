package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessage;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOWER_BOUND_NUMBER = 1;
    public static final int UPPER_BOUND_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_EXCEPTION.toString());
        }
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_EXCEPTION.toString());
        }
        if (isNotSameSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_EXCEPTION.toString());
        }
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_EXCEPTION.toString());
        }
        if (hasDuplication(numbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_EXCEPTION.toString());
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(Integer number) {
        return number < LOWER_BOUND_NUMBER || number > UPPER_BOUND_NUMBER;
    }


    private boolean hasDuplication(List<Integer> numbers) {
        final Set<Integer> noDuplicatedNumbers = new HashSet<>(numbers);
        return noDuplicatedNumbers.size() != numbers.size();
    }

    private boolean hasDuplication(List<Integer> numbers, Integer number) {
        return numbers.contains(number);
    }
    
    private boolean isNotSameSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
