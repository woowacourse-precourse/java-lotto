package controller;

import domain.Lotto;
import domain.LottoMachine;
import input.MoneyInput;
import view.RequestView;

import java.util.List;

public class LottoController {

    private RequestView requestView = new RequestView();
    private MoneyInput moneyInput = new MoneyInput();

    private LottoMachine machine;
    private List<Lotto> lotteries;

    public void purchase() {
        requestView.displayEnterPurchaseAmount();
        machine = new LottoMachine(moneyInput.getPurchaseAmount());
        lotteries = machine.lottoForAmount();
    }

    public void winnerNumber() {
        requestView.displayEnterWinnerNumber();
    }

    public void bonusNumber() {
        requestView.displayEnterBonusNumber();
    }

}
