package lotto.domain;

import lotto.view.ErrorMessage;

import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoNumberDuplication(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumberDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage
                    .GET_ERROR_FOR_INPUT_WINNING_NUMBER_SIZE
                    .getMessage());
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(START_NUMBER <= number && number <= END_NUMBER)) {
                throw new IllegalArgumentException(ErrorMessage
                        .GET_ERROR_FOR_INPUT_WINNING_NUMBER_COUNT
                        .getMessage());
            }
        }
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }
}
