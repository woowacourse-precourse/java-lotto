package lotto.condition.money;

import lotto.condition.Condition;

public class IsAllNumberCond implements Condition {
    private static final Condition instance = new IsAllNumberCond();

    private IsAllNumberCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return input.matches("[1-9][0-9]*");
    }
}
