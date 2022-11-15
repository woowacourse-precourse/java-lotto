package lotto.domain;

import lotto.view.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw ErrorMessage.LENGTHBOUNDS.getError();
        }
    }

    // TODO: 추가 기능 구현

    private void duplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw ErrorMessage.DUPLICATE.getError();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
