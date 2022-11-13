package lotto.model;

import java.util.List;
import lotto.util.constants.GameConstants;
import lotto.util.constants.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (!isSameSizeAsLotto(numbers.size())) {
            throw new IllegalArgumentException(GameConstants.ERROR_IS_NOT_SAME_LOTTO_SIZE);
        }
    }

    private boolean isSameSizeAsLotto(int numberSize) {
        return numberSize != LottoConstants.LOTTO_TICKET_SIZE;
    }


}
