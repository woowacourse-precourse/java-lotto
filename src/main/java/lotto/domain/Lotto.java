package lotto.domain;

import java.util.List;
import java.util.Set;
import lotto.Constants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbersLength(numbers);
        validateLottoNumbersDuplicated(numbers);
        validateNumbersSorted(numbers);

        this.numbers = numbers;
    }

    private void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException("6개의 숫자가 아닙니다.");
        }
    }

    private void validateLottoNumbersDuplicated(List<Integer> numbers) {
        Set<Integer> numbersSet = Set.copyOf(numbers);
        if (numbersSet.size() != Constants.LOTTO_NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }

    private void validateNumbersSorted(List<Integer> numbers) {
        for (int i = 0; i < Constants.LOTTO_NUMBERS_LENGTH.getValue() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                throw new IllegalArgumentException("숫자가 정렬되어 있지 않습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
