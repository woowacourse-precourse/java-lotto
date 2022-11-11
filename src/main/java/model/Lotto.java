package model;

import java.util.List;

import static model.ErrorMessage.INCORRECT_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoStatus.SIZE.getValue()) {
            throw new IllegalArgumentException(INCORRECT_SIZE.toString());
        }
    }
}
