package lotto.domain;

import lotto.constant.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_OF_LOTTO_NUMBERS_SHOULD_BE_SIX.getErrorMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_SHOULD_BE_UNIQUE.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        numbers.sort(Comparator.comparingInt(o -> o));
        return numbers.toString();
    }
}
