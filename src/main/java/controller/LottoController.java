package controller;

import domain.Lotto;
import domain.LottoMachine;
import input.MoneyInput;
import view.RequestView;
import view.ResultView;

import java.util.List;

public class LottoController {

    private RequestView requestView = new RequestView();
    private MoneyInput moneyInput = new MoneyInput();
    private ResultView resultView = new ResultView();

    private LottoMachine machine;
    private List<Lotto> lotteries;

    public void purchase() {
        requestView.displayEnterPurchaseAmount();
        machine = new LottoMachine(moneyInput.getPurchaseAmount());
        lotteries = machine.lottoForAmount();
        resultView.displayAllLotteries(lotteries);
    }

    public void winnerNumber() {
        requestView.displayEnterWinnerNumber();
    }

    public void bonusNumber() {
        requestView.displayEnterBonusNumber();
    }

}
