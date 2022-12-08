package controller;

import domain.Result;
import domain.lotto.BonusNumber;
import domain.lotto.Lotto;
import domain.lotto.LottoMachine;
import domain.lotto.Lottos;
import domain.Money;
import util.InputHandler;
import view.OutputView;

public class LottoController {

    OutputView outputView = new OutputView();
    InputHandler inputHandler = new InputHandler();
    LottoMachine lottoMachine = new LottoMachine();
    Result result = new Result();

    Lotto winningLotto;
    Lottos lottos;
    BonusNumber bonusNumber;

    public void run(){
        Money money = sell();
        makeRandomLotteries(money);
        makeWinningLottoAndBonusNumber();
        result(money);
    }

    private void result(Money money) {
        result.compareNumbers(lottos, winningLotto, bonusNumber);
        outputView.printResult(result.winning, result.calculateEarningRate(result.total_prize, money));
    }

    private void makeWinningLottoAndBonusNumber() {
        winningLotto = new Lotto(inputHandler.getWinningNumbers());
        bonusNumber = new BonusNumber(inputHandler.getBonusNumber(winningLotto));
    }

    private void makeRandomLotteries(Money money) {
        lottos = lottoMachine.makeLotteries(money);
        outputView.printLotteriesNumbers(lottos);
    }

    private Money sell() {
        Money money = new Money(inputHandler.getMoney());
        outputView.printHowManyLottery(money);
        return money;
    }
}
