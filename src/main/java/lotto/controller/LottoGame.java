package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.domain.User;
import lotto.domain.lotto.PurchaseLottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.statistics.WinningStatistics;

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

        user.displayPurchaseResult(purchaseLottos);

        WinningLotto winningLotto = inputWinningLotto();

        WinningStatistics winningStatistics = createWinningStatistics(purchaseLottos, winningLotto);

        user.displayGameResult(winningStatistics);
    }

    private WinningLotto inputWinningLotto() {
        return user.inputLotto();
    }

    private PurchaseLottos purchaseLotto() {
        PurchaseAmount purchaseAmount = user.inputPurchaseAmount();
        return new PurchaseLottos(purchaseAmount.quantity());
    }

    private WinningStatistics createWinningStatistics(PurchaseLottos purchaseLottos, WinningLotto winningLotto) {
        return new WinningStatistics(purchaseLottos, winningLotto);
    }
}
