package lotto.condition.lottonumber;

import lotto.Utils;
import lotto.condition.Condition;

import static lotto.domain.lottomachine.LottoMachine.LOTTO_NUMBER_SIZE;

public class InSizeCond implements Condition {

    private static final Condition instance = new InSizeCond();
    private static final String ERROR_MESSAGE = "6개의 숫자로 구성되어야 합니다";

    private InSizeCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return Utils.getParsedNumbers(input).size() <= LOTTO_NUMBER_SIZE;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
