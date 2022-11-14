package lotto.Controller;

import lotto.Constant.Message;
import lotto.Model.Buyer;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Controll {

    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private Buyer buyer;

    public void run() {
        try {
            buyTicket();
            outputView.printLotto(buyer.getLottoNumber());
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
        }
    }

    private void buyTicket() {
        outputView.printMessage(Message.START.getMessage());
        buyer = new Buyer(inputView.inputNum());
    }
}
