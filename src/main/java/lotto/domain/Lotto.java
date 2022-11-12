package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ERROR_NUMBERS_COUNT = "[ERROR] 로또 숫자는 6개여야 합니다.";
    private static final String ERROR_NUMBER_DUPLICATION = "[ERROR] 중복된 번호가 존재합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_NUMBERS_COUNT);
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_NUMBER_DUPLICATION);
        }
    }

    // TODO: 추가 기능 구현
}
