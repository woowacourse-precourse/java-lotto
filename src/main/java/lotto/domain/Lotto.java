package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final String LOTTO_INVALID_SIZE_ERROR = "[ERROR] 로또 번호가 6자리가 아닙니다.";
    private static final String LOTTO_DUPLICATED_SIZE_ERROR = "[ERROR] 로또 번호가 중복되었습니다.";
    private static final String LOTTO_INVALID_RANGE_ERROR = "[ERROR] 로또 번호의 범위를 잘못 입력하였습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
        validateDuplicate();
        validateRange();
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

    private void validateRange() {
        for (int number: numbers) {
            if (!(number > 0 && number < 46)) {
                throw new IllegalArgumentException(LOTTO_INVALID_RANGE_ERROR);
            }
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
