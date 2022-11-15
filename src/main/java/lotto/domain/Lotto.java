package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final String LOTTO_INVALID_SIZE_ERROR = "[ERROR] 로또 번호가 6자리가 아닙니다.";
    private static final String LOTTO_DUPLICATED_SIZE_ERROR = "[ERROR] 로또 번호가 중복되었습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
        validateDuplicate();
    }

    private void validate() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_INVALID_SIZE_ERROR);
        }
    }

    private void validateDuplicate() {
        HashSet<Integer> lotto = new HashSet<>(numbers);
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED_SIZE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
