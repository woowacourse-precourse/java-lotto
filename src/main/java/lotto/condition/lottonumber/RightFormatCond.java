package lotto.condition.lottonumber;

import lotto.LottoMachine;
import lotto.condition.Condition;

public class RightFormatCond implements Condition {

    private static final Condition instance = new RightFormatCond();

    private RightFormatCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return input.split(",").length == LottoMachine.LOTTO_NUMBER_SIZE;
    }
}
