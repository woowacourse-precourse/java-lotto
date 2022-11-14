package lotto.domain;

import java.util.function.Function;

public enum Prize {
    CALCULATE_FIRST(value -> value * 2000000000),
    CALCULATE_SECOND(value -> value * 30000000),
    CALCULATE_THIRD(value -> value * 1500000),
    CALCULATE_FOURTH(value -> value * 50000),
    CALCULATE_FIFTH(value -> value * 5000);

    private Function<Integer, Integer> expression;

    Prize(Function<Integer, Integer> expression) {
        this.expression = expression;
    }

    public int calculate(Integer value) {
        return expression.apply(value);
    }
}
