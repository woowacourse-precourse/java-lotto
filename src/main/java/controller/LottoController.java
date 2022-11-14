package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.Profit;
import domain.Money;
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

    private Money validatedMoney;
    private LottoMachine machine;
    private List<Lotto> lotteries;
    private Lotto winnerNumber;
    private int bonusNumber;
    private Profit profit;

    public void purchase() {
        requestView.displayEnterPurchaseAmount();
        validatedMoney = new Money(moneyInput.getPurchaseAmount());
        machine = new LottoMachine(validatedMoney.getMoney());
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

    public void statistics() {
        resultView.displayWinStatistics();
        resultView.displayPercentageProfit(profit.getPercentageProfit());
    }

}
