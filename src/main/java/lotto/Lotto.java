package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static final String LOTTO_SIZE_ERROR_MESSAGE = "[ERROR] 로또번호는 총 6자리여야 합니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또번호는 1부터 45 사이의 정수여야 합니다.";
    private static final String LOTTO__DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 로또번호가 존재합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (!(numbers.get(i) >= 1 && numbers.get(i) <= 45)) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }

        Set<Integer> set = new HashSet<Integer>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO__DUPLICATE_NUMBER_ERROR_MESSAGE);
        }

    }

    // TODO: 추가 기능 구현
}
