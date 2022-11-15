package lotto.condition.money;

import lotto.condition.Condition;

public class IsAllNumberCond implements Condition {

    private static final Condition instance = new IsAllNumberCond();
    private static final String NUMBER_REGEX = "[1-9][0-9]*";
    private static final String ERROR_MESSAGE = "숫자만 입력 가능 합니다.";

    private IsAllNumberCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return input.matches(NUMBER_REGEX);
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
