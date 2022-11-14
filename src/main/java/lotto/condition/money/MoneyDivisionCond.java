package lotto.condition.money;

import lotto.condition.Condition;

public class MoneyDivisionCond implements Condition {

    private static final Integer UNIT = 1000;
    private static final Condition instance = new MoneyDivisionCond();
    private static final String ERROR_MESSAGE = "1000원 단위로 입력하세요";

    private MoneyDivisionCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return Integer.parseInt(input) % UNIT == 0;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
