package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final String INVALID_LOTTO_SIZE = "[ERROR] 로또는 6개의 숫자로 이루어져야 합니다.";
    private static final String INVALID_NUMBER_RANGE = "[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isValidLottoSize(numbers);
        isValidNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(numbers);
    }

    private void isValidLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    private void isValidNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
            }
        }
    }
}
