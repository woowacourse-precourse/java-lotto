package lotto.domain.getwin.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    static final int LOTTO_NUMBER_START = 1;
    static final int LOTTO_NUMBER_END = 45;
    static final int LOTTO_NUMBER_CNT = 6;
    static final String ERROR_ONLY_SIX_NUMBER = "[ERROR] 당첨번호는 6개여야 합니다";
    static final String ERROR_LOTTO_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final String ERROR_NO_DUPLICATE = "[ERROR] 로또 번호는 중복이 없어야 합니다.";
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
            if ((numbers.get(i) < LOTTO_NUMBER_START) || (numbers.get(i) > LOTTO_NUMBER_END))
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
