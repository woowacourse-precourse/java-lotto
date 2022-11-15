package lotto.game.domain;

import static lotto.game.ExceptionConst.*;
import static lotto.game.LottoConst.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        for (Integer number : numbers) {
            validateLottoNumber(number);
        }
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NOT_SIX_NUMBER_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long noDuplicateCount = numbers.stream()
                .distinct()
                .count();
        if (noDuplicateCount != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    protected void validateLottoNumber(Integer number) {
        if (number >= MIN_LOTTO_NUM && number <= MAX_LOTTO_NUM) {
            return;
        }
        throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_MESSAGE);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
