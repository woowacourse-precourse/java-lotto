package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoStringConstant.*;

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
    }

    @Override
    public String toString() {
        numbers.sort(Comparator.naturalOrder());
        List<String> stringNumbers = numbers.stream().map(Object::toString).collect(Collectors.toList());
        return FRONT_BRACKET+String.join(NUMBER_SEPARATOR,stringNumbers)+BACK_BRACKET;
    }
}
