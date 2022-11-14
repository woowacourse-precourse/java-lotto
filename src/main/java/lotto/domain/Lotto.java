package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.SIZE.getValue()) {
            return false;
        }
        return true;
    }

}
