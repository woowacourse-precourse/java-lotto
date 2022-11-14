package lotto.domain;


import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private static final String LOTTO_NUMBER_MUST_SIX = "번호는 6개여야 합니다.";
    private static final String LOTTO_NUMBER_NOT_DUPLICATE = "번호는 중복되면 안됩니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_MUST_SIX);
        }
    }

    // TODO: 추가 기능 구현

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
