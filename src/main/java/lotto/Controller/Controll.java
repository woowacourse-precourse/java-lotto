package lotto.Controller;

import lotto.Constant.Message;

import lotto.View.InputView;
import lotto.View.OutputView;

public class Controll {

    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void run() {
        try {
            buyTicket();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
        }
    }

    private void buyTicket() {
        outputView.printMessage(Message.START.getMessage());
        inputView.inputNum();
    }
}
