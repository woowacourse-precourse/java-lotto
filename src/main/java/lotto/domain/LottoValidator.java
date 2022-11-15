package lotto.domain;

import lotto.exception.DuplicateLottoNumberException;

import java.util.List;

public class LottoValidator extends CanValidateLotto<List<Integer>> {
    @Override
    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        numbers.forEach(this::validateNumberIsInRange);
        validateNoDuplicateNumberIsIn(numbers);
    }

    private void validateNoDuplicateNumberIsIn(List<Integer> numbers) {
        for (int index = 0; index < numbers.size() - 1; index++) {
            isDuplicate(numbers.get(index), numbers.get(index + 1));
        }
    }

    private void isDuplicate(int numberToCompare, int numberWithNext) {
        if (numberToCompare == numberWithNext) {
            throw new DuplicateLottoNumberException();
        }
    }
}
