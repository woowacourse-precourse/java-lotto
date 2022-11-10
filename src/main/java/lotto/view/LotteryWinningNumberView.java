package lotto.view;

import lotto.constant.StringConstant;

public class LotteryWinningNumberView extends View{

    private String userInput;

    @Override
    public void show() {
        OutputView.printEndsWithEnter(StringConstant.WINNING_LOTTERY_NUMBER_INPUT_MESSAGE.getMessage());
        this.userInput = InputView.input();
    }

    @Override
    public String getResponse() {
        return this.userInput;
    }



}
