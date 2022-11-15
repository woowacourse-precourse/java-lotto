package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Const.*;
import static lotto.ErrorPhrase.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numberRangeValidate(numbers);
        lengthValidate(numbers);
        duplicateValidate(numbers);
    }

    // TODO: 추가 기능 구현
    private void lengthValidate(List<Integer> numbers) {
        if (!(numbers.size() == SIZE)) {
            throw new IllegalArgumentException(WRONG_LENGTH.toString());
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        duplicateCheck.addAll(numbers);

        if (!(duplicateCheck.size() == SIZE)) {
            throw new IllegalArgumentException(DUPLICATE.toString());
        }
    }

    private void numberRangeValidate(List<Integer> numbers) {
        boolean illegal = !numbers.stream()
                .allMatch((number) -> 1 <= number && number <= 45);

        if (illegal) {
            throw new IllegalArgumentException(WRONG_RANGE.toString());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
