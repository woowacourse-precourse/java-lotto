package lotto.model;

import lotto.controller.ExceptionHandler;
import lotto.view.InputView;

public class Bonus {
    private Integer num;

    public Bonus() {
        setBonus();
    }

    private void setBonus() {
        String numString = InputView.inputBonusNum();
        ExceptionHandler.validateBonusNum(numString);
        this.num = Integer.parseInt(numString);
    }

    public Integer getNum() {
        return num;
    }
}
