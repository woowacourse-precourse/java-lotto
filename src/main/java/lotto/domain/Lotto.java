package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoNumber.MIN.getNumber()
                    || number > LottoNumber.MAX.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> differentNumbers = new HashSet<>(numbers);
        if (differentNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
