package lotto.view;

import lotto.constant.StringConstant;

public class BonusLottoView extends View{

    private String userInput;
    @Override
    public void show() {
        OutputView.printEndsWithEnter(StringConstant.BONUS_LOTTO_INPUT_MESSAGE.getMessage());
        this.userInput = InputView.input();
    }

    @Override
    public String getResponse() {
        return this.userInput;
    }
}
