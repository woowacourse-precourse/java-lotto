package lotto.condition;

import lotto.LottoMachine;

public class RightFormatCond implements Condition {

    private static final Condition instance = new RightFormatCond();

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return input.split(",").length == LottoMachine.LOTTO_NUMBER_SIZE;
    }
}
