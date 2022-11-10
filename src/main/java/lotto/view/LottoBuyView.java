package lotto.view;

import lotto.constant.StringConstant;

public class LottoBuyView extends View{

    private String userInput;

    @Override
    public void show() {
        OutputView.printEndsWithEnter(StringConstant.MONEY_INPUT_MESSAGE.getMessage());
        this.userInput = InputView.input();
    }

    @Override
    public String getResponse() {
        return userInput;
    }
}
