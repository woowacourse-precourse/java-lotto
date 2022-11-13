package controller;

import domain.Lotto;
import domain.LottoMachine;
import input.MoneyInput;
import input.NumberInput;
import view.RequestView;
import view.ResultView;

import java.util.List;

public class LottoController {

    private RequestView requestView = new RequestView();
    private MoneyInput moneyInput = new MoneyInput();
    private ResultView resultView = new ResultView();
    private NumberInput numberInput = new NumberInput();

    private LottoMachine machine;
    private List<Lotto> lotteries;
    private Lotto winnerNumber;
    private int bonusNumber;

    public void purchase() {
        requestView.displayEnterPurchaseAmount();
        machine = new LottoMachine(moneyInput.getPurchaseAmount());
        lotteries = machine.lottoForAmount();
        resultView.displayAllLotteries(lotteries);
    }

    public void winnerNumber() {
        requestView.displayEnterWinnerNumber();
        winnerNumber = new Lotto(numberInput.getWinningNumbers());
    }

    public void bonusNumber() {
        requestView.displayEnterBonusNumber();
        bonusNumber = numberInput.getBonusNumber();
    }

}
