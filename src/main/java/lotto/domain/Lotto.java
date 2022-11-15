package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.constant.ErrorMessage.LENGTH_OF_LOTTO_NUMBERS_SHOULD_BE_SIX;
import static lotto.domain.constant.ErrorMessage.LOTTO_NUMBERS_SHOULD_BE_UNIQUE;

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
            throw new IllegalArgumentException(LENGTH_OF_LOTTO_NUMBERS_SHOULD_BE_SIX.getErrorMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SHOULD_BE_UNIQUE.getErrorMessage());
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
