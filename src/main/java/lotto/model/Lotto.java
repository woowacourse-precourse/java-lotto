package lotto.model;

import lotto.utils.Errors;
import lotto.utils.Rules;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validateLength(numbers);
        validatedLottoRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != Rules.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validatedLottoRange(List<Integer> numbers) throws IllegalArgumentException {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) throws IllegalArgumentException {
        if ((number < Rules.LOTTO_MIN_NUMBER) || (number > Rules.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(Errors.ERROR_LOTTO_NUMBER_RANGE.getValue());
        }
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != Rules.LOTTO_SIZE) {
            throw new IllegalArgumentException(Errors.ERROR_LOTTO_NUMBER_DUPLICATE.getValue());
        }
    }

    public int findLottoNumber(int index) {
        return numbers.get(index);
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
}
