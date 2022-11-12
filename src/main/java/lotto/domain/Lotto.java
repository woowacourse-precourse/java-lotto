package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void duplicateValidate(List<Integer> numbers) {
        List<Integer> number = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (number.contains(numbers.get(i))) {
                throw new IllegalArgumentException();
            }
            number.add(numbers.get(i));
        }
    }

}
