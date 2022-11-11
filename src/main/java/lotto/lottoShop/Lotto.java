package lotto.lottoShop;

import java.util.List;

import static lotto.Enum.Constant.*;
import static lotto.Enum.Error.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNum(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNum(List<Integer> numbers) {
        validateLottoNumLength(numbers);
        validateLottoNumDuplicated(numbers);
        validateLottoNumRange(numbers);
    }

    private void validateLottoNumLength(List<Integer> numbers) {
        if (numbers.size() != SIX.getIntValue()) {
            throw new IllegalArgumentException(LOTTO_NUM_LENGTH_ERROR.getMessage());
        }
    }

    private void validateLottoNumDuplicated(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != SIX.getIntValue()) {
            throw new IllegalArgumentException(LOTTO_NUM_DUPLICATED_ERROR.getMessage());
        }
    }

    private void validateLottoNumRange(List<Integer> numbers) {
        if (numbers.stream()
                .filter(this::checkLottoNumRange)
                .count() != SIX.getIntValue()) {
            throw new IllegalArgumentException(LOTTO_NUM_RANGE_ERROR.getMessage());
        }
    }

    public boolean checkLottoNumRange(int num) {
        return num > ZERO.getIntValue()
                && num <= FOURTY_FIVE.getIntValue();
    }
}
