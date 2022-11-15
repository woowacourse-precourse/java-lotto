package lotto.domain;

import java.util.function.Function;

public enum Prize {
    CALCULATE_THREE(value -> value * 5000),
    CALCULATE_FOUR(value -> value * 50000),
    CALCULATE_FIVE(value -> value * 1500000),
    CALCULATE_SIX(value -> value * 2000000000),
    CALCULATE_BONUS(value -> value * 30000000);

    private Function<Integer, Integer> expression;

    Prize(Function<Integer, Integer> expression) {
        this.expression = expression;
    }

    public float calculate(Integer value) {
        return expression.apply(value);
    }
}
