package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final String DUPLICATION_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 중복되지 않은 숫자만 입력 가능합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = duplicateValidate(numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> duplicateValidate(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        if (lotto.size() == lotto.size()) {
            return numbers;
        }
        throw new IllegalArgumentException(DUPLICATION_NUMBER_EXCEPTION_MESSAGE);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(this.numbers);
    }
}
