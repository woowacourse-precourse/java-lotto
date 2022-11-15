package lotto.domain;

import lotto.validate.Validator;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validLottoNumberSize(numbers);
        Validator.validDuplicateNumbers(numbers);
    }

    public long containsResultCount(List<Integer> result) {
        return numbers.stream()
                .filter(result::contains)
                .count();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
