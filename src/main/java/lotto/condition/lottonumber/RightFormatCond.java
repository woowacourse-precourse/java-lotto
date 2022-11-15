package lotto.condition.lottonumber;

import lotto.condition.Condition;
import lotto.domain.lottomachine.LottoMachine;

public class RightFormatCond implements Condition {

    private static final Condition instance = new RightFormatCond();
    private static final String ERROR_MESSAGE = "6개의 숫자를 콤마(,)로 구분하여 입력하세요";

    private RightFormatCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return input.split(",").length == LottoMachine.LOTTO_NUMBER_SIZE;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
