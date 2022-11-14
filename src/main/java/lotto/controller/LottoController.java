package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.*;
import lotto.model.enums.GameMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Price price;
    private Lotto lotto;
    private Lottos lottos;
    private LuckySix luckySix;
    private LuckyBonus luckyBonus;
    private WinningResult winningResult;
    private Profit profit;

    public void start() {
        buyLotto();
        showTicket();
        pickLuckySix();
        pickLuckyBonus();
        showWinningResult();
        showProfit();
    }

    private void buyLotto() {
        String inputPrice = InputView.getPrice();
        price = new Price(inputPrice);
    }

    private void showTicket() {
        OutputView.showTicketAmount(price.calculateCount());
        lottos = new Lottos(price.calculateCount());
        OutputView.showDrawNumber(lottos);
    }

    private void pickLuckySix() {
        String inputLuckySix = InputView.getLuckySix();
        luckySix = new LuckySix(inputLuckySix);
    }

    private void pickLuckyBonus() {
        String inputLuckyBonus = InputView.getLuckyBonus();
        luckyBonus = new LuckyBonus(inputLuckyBonus);
    }

    private void showWinningResult() {
        winningResult = new WinningResult(price.calculateCount(), lottos);
        OutputView.showWinningResult(winningResult.winningResult);
    }

    private void showProfit() {
        profit = new Profit(price.price);
        OutputView.printProfitRate(profit.profitRate);
    }
}
