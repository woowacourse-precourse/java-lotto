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
        sixLetterValidate(numbers);
        duplicateValidate(numbers);
    }

    // TODO: 추가 기능 구현
    private void sixLetterValidate(List<Integer> numbers) {
        if (!SIZE.equals(numbers.size())) {
            throw new IllegalArgumentException(WRONG_LENGTH.toString());
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        duplicateCheck.addAll(numbers);

        if (!SIZE.equals(duplicateCheck.size())) {
            throw new IllegalArgumentException(DUPLICATE.toString());
        }
    }
}
