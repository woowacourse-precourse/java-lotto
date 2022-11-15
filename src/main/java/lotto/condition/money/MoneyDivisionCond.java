package lotto.condition.money;

import lotto.condition.Condition;

import static lotto.domain.lottomachine.LottoMachine.UNIT;

public class MoneyDivisionCond implements Condition {

    private static final Condition instance = new MoneyDivisionCond();
    private static final String ERROR_MESSAGE = "1000원 단위로 입력하세요";

    private MoneyDivisionCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return Integer.parseInt(input) / UNIT >= 1 && Integer.parseInt(input) % UNIT == 0;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
