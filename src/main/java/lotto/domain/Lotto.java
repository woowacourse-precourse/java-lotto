package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_IS_NOT_CORRECT_SIZE.getMessage());
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        if (checkDuplicateInNumbers(numbers)) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBERS_IS_CONTAIN_DUPLICATE.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!isNumbersInRange(numbers)) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }

    private boolean checkDuplicateInNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private boolean isNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(num -> MIN_LOTTO_NUMBER <= num && num <= MAX_LOTTO_NUMBER);
    }

    public int countMatch(Lotto winningNumbers) {
        return (int) numbers
                .stream()
                .filter(winningNumbers::containNumber)
                .count();
    }

    public boolean containNumber(Integer number) {
        return numbers.contains(number);
    }

    public String toStringNumbers() {
        return numbers.toString();
    }
}