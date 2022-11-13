package lotto.domain;

import lotto.ui.ErrorMessage;
import lotto.ui.LottoValidator;
import lotto.util.Log;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Log.error(ErrorMessage.INVALID_SIZE.getMessage());
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.getMessage());
        }

        if (LottoValidator.isDuplication(numbers)) {
            Log.error(ErrorMessage.LOTTO_DUPLICATION.getMessage());
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
