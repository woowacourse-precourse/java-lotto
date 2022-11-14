package lotto.domain.lotto;

import lotto.global.message.ErrorMessage;
import lotto.global.message.Number;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final String COMMA_WITH_BLANK = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (invalidRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
        if (duplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
        }
    }

    private boolean duplicate(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != Number.LOTTO_SIZE;
    }

    private boolean invalidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < Number.MIN_NUMBER_RANGE || number > Number.MAX_NUMBER_RANGE);
    }

    public String getNumbers() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_WITH_BLANK));
    }

    // TODO: 추가 기능 구현
}
