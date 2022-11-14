package lotto.domain.model;

import java.util.List;
import lotto.exception.LottoGameExceptionHandler;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoGameExceptionHandler.handleLottoException(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
