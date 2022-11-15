package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Price userPrice;
    private Lotto userLotto;
    private Lottos userLottos;
    private LuckySix userLuckySix;
    private LuckyBonus userLuckyBonus;
    private WinningResult userWinningResult;
    private Profit userProfit;

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
        userPrice = new Price(inputPrice);
    }

    private void showTicket() {
        OutputView.showTicketAmount(userPrice.calculateCount());
        userLottos = new Lottos(userPrice.calculateCount());
        OutputView.showDrawNumber(userLottos.lottos);
    }

    private void pickLuckySix() {
        String inputLuckySix = InputView.getLuckySix();
        userLuckySix = new LuckySix(inputLuckySix);
    }

    private void pickLuckyBonus() {
        String inputLuckyBonus = InputView.getLuckyBonus();
        userLuckyBonus = new LuckyBonus(inputLuckyBonus, userLuckySix.luckySix);
    }

    private void showWinningResult() {
        userWinningResult = new WinningResult(userPrice.calculateCount(), userLottos.lottos, userLuckySix.luckySix, userLuckyBonus.luckyBonus);
        OutputView.showWinningResult(userWinningResult.winningResult);
    }

    private void showProfit() {
        userProfit = new Profit(userPrice.price, userWinningResult.winningResult);
        OutputView.printProfitRate(userProfit.profitRate);
    }
}
