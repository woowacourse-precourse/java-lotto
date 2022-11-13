package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        numbers.sort(Comparator.naturalOrder());
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("6개의 숫자를 입력해야 합니다.");

        checkNumberDuplicated(numbers);
    }

    private void checkNumberDuplicated(List<Integer> numbers) {
        Integer beforeNumber = -1;

        for (Integer number: numbers) {
            if (beforeNumber == number)
                throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
            beforeNumber = number;
        }
    }
}
