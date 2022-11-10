package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        for (Integer number : copyNumbers) {
            if (copyNumbers.indexOf(number) != copyNumbers.lastIndexOf(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
}
