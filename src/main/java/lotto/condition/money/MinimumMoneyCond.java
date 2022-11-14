package lotto.condition.money;

import lotto.condition.Condition;

public class MinimumMoneyCond implements Condition {

    private static final Integer UNIT = 1000;
    private static final Condition instance = new MinimumMoneyCond();

    private MinimumMoneyCond() {
    }

    public static Condition getInstance() {
        return instance;
    }


    @Override
    public Boolean isSatisfied(String input) {
        return Integer.parseInt(input) >= UNIT;
    }
}
