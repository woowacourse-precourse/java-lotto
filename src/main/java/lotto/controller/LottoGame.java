package lotto.controller;

import static lotto.domain.statistics.WinningStatistics.createWinningStatistics;
import static lotto.domain.statistics.YieldRate.calcYieldRate;
import static lotto.view.PurchaseMessage.makePurchaseLottoMessage;

import lotto.domain.PurchaseAmount;
import lotto.domain.User;
import lotto.domain.lotto.PurchaseLottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.statistics.PlaceHistory;
import lotto.domain.statistics.WinningStatistics;
import lotto.domain.statistics.YieldRate;

public class LottoGame {

    private final User user;

    public LottoGame(User user) {
        this.user = user;
    }

    public void play() {
        try {
            run();
        } catch (IllegalArgumentException illegalArgumentException) {
            user.displayErrorMessage(illegalArgumentException);
        }

    }

    private void run() {
        PurchaseLottos purchaseLottos = purchaseLotto();
        user.displayPurchaseResult(makePurchaseLottoMessage(purchaseLottos));

        WinningLotto winningLotto = user.inputWinningLotto();

        PlaceHistory placeHistory = purchaseLottos.placeHistoryFor(winningLotto);
        YieldRate yieldRate = calcYieldRate(purchaseLottos.calculateAmount(), placeHistory.amountSum());

        WinningStatistics winningStatistics = createWinningStatistics(placeHistory, yieldRate);

        user.displayGameResult(winningStatistics);
    }

    private PurchaseLottos purchaseLotto() {
        PurchaseAmount purchaseAmount = user.inputPurchaseAmount();
        return new PurchaseLottos(purchaseAmount.quantity());
    }

}
