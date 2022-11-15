package lotto;

import java.util.List;
import java.util.function.Function;

public enum ValidationType {
    CHECK_SIZE_NUMBERS(numbers -> numbers.size() == 6),
    CHECK_DUPLICATE_NUMBERS(numbers -> numbers.stream().distinct().count() == 6),
    CHECK_RANGE_NUMBERS(numbers -> numbers.stream()
            .filter(number -> number >= 1)
            .filter(number -> number <= 45)
            .count() == 6);

    private Function<List<Integer>, Boolean> expression;

    ValidationType(Function<List<Integer>, Boolean> expression) {
        this.expression = expression;
    }

    public Boolean validateNumbers(List<Integer> numbers) {
        return expression.apply(numbers);
    }
}
