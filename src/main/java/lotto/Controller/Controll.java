package lotto.Controller;

import lotto.Constant.Message;
import lotto.Model.Buyer;
import lotto.Model.Comparison;
import lotto.Model.Money;
import lotto.Model.WinningTicket;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Controll {

    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private Buyer buyer;
    private WinningTicket winningTicket;
    private Comparison comparison = new Comparison();
    private Money money = new Money();

    public void run() {
        try {
            buyTicket();
            outputView.printLotto(buyer.getLottoNumber());
            winnginTicket();
            comparison.compareLotto(buyer.getLottoNumber(), winningTicket);
            outputView.printResult(comparison.getSavedResult());
            money.calculrateReturnRate(comparison.getSavedResult());
            outputView.printPrizeMoney(money.getPrizeMoney(), buyer.getBuyerMoney());
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

        outputView.printMessage("\n" + Message.BONUS_NUMBER.getMessage());
        winningTicket.saveBonus(inputView.inputNum());
    }
}
