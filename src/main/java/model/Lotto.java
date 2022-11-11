package model;

import java.util.List;

import static model.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoStatus.SIZE.getValue()) {
            throw new IllegalArgumentException(INCORRECT_SIZE.toString());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (isOutOfRange(getNumber(numbers, index))) {
                throw new IllegalArgumentException(OUT_OF_RANGE.toString());
            }
        }
    }

    private Integer getNumber(List<Integer> numbers, int index) {
        return numbers.get(index);
    }

    private boolean isOutOfRange(Integer number) {
        return number < LottoStatus.START.getValue() || number > LottoStatus.END.getValue();
    }
}
