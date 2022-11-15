package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.error.ErrorMessage.LOTTO_NUMBER_DUPLICATE;
import static lotto.error.ErrorMessage.LOTTO_NUMBER_OVERSIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        lottoOverSizeValidate(numbers);
        duplicateValidate(numbers);
    }

    private void lottoOverSizeValidate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OVERSIZE.getMessage());
        }
    }

    private void duplicateValidate(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> duplicateCheck = new HashSet<>();
        for (int number: numbers) {
            if (duplicateCheck.contains(number)) {
                throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
            }
            duplicateCheck.add(number);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
