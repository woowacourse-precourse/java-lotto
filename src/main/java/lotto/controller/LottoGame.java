package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.domain.User;
import lotto.domain.lotto.PurchaseLottos;
import lotto.domain.lotto.WinningLotto;

public class LottoGame {

    private final User user;
    private PurchaseLottos purchaseLottos;
    private WinningLotto winningLotto;


    public LottoGame(User user) {
        this.user = user;
    }

    public void run() {
        purchaseLotto();
        inputWinningLotto();
    }

    private void inputWinningLotto() {
        this.winningLotto = user.inputLottoNum();
    }

    private void purchaseLotto() {
        PurchaseAmount purchaseAmount = user.inputPurchaseAmount();
        this.purchaseLottos = new PurchaseLottos(purchaseAmount.quantity());
    }
}
