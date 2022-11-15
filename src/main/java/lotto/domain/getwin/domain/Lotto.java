package lotto.domain.getwin.domain;

import java.util.Collections;
import java.util.List;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.Integer.*;

public class Lotto {
    public final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_CNT) {
            throw new IllegalArgumentException(ERROR_ONLY_SIX_NUMBER);
        }
        if (!numbersInRange(numbers)) {
            throw new IllegalArgumentException(ERROR_LOTTO_OUT_OF_RANGE);
        }
        if (!numbersAllDifferent(numbers)) {
            throw new IllegalArgumentException(ERROR_NO_DUPLICATE);
        }
    }

    private boolean numbersInRange(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_NUMBER_CNT; i++)
            if ((numbers.get(i) < LOTTO_NUMBER_MIN) || (numbers.get(i) > LOTTO_NUMBER_MAX))
                return false;
        return true;
    }

    private boolean numbersAllDifferent(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_NUMBER_CNT; i++) {
            int tmp = numbers.get(i);
            if (Collections.frequency(numbers, tmp) > 1)
                return false;
        }
        return true;
    }
}
