package lotto.model.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final String LEFT_BRACKETS = "[";
    private static final String RIGHT_BRACKETS = "]";
    private static final String NUMBER_SEPARATOR = ", ";
    private static final String NEW_LINE = "\n";

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
        String numbersToString = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_SEPARATOR));

        return LEFT_BRACKETS + numbersToString + RIGHT_BRACKETS + NEW_LINE;
    }

    // TODO: 추가 기능 구현
}
