package lotto.Controller;

import lotto.Constant.Message;
import lotto.Model.Buyer;
import lotto.Model.WinningTicket;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Controll {

    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private Buyer buyer;
    private WinningTicket winningTicket;

    public void run() {
        try {
            buyTicket();
            outputView.printLotto(buyer.getLottoNumber());
            winnginTicket();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
        }
    }

    private void buyTicket() {
        outputView.printMessage(Message.START.getMessage());
        buyer = new Buyer(inputView.inputNum());
    }

    private void winnginTicket() {
        outputView.printMessage("\n" + Message.WINNING_NUMBER.getMessage());
        winningTicket = new WinningTicket(inputView.inputNum());
    }
}
