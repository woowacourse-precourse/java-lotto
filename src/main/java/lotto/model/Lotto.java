package lotto.model;

import java.util.List;

public class Lotto {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NUMBER_IS_NOT_SIX = "로또가 6개보다 많거나 적은 수의 번호를 가진 채 발행됐습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_PREFIX + NUMBER_IS_NOT_SIX);
        }
    }
}
