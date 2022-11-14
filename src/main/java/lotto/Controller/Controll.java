package lotto.Controller;

import lotto.Constant.Message;
import lotto.View.OutputView;

public class Controll {

    private OutputView outputView = new OutputView();

    public void run() {
        try {
            buyTicket();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
        }
    }

    private void buyTicket() {
        outputView.printMessage(Message.START.getMessage());

    }
}
