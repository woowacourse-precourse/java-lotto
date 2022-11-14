package lotto.condition.money;

import lotto.condition.Condition;

public class MinimumMoneyCond implements Condition {

    private static final Integer UNIT = 1000;
    private static final Condition instance = new MinimumMoneyCond();
    private static final String ERROR_MESSAGE = "1000원 이상을 입력하세요";

    private MinimumMoneyCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return Integer.parseInt(input) >= UNIT;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
