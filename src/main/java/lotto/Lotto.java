package lotto;

import lotto.ENUMS.ErrorMessages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> checkDup = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.COUNT_ERROR.getErrorMessage());
        }
        if (checkDup.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_ERROR.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
    public int size() {
        return numbers.size();
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
