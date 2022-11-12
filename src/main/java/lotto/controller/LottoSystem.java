package lotto.controller;

import lotto.domain.UserLotto;
import lotto.view.InputView;

public class LottoSystem {
    private static final InputView inputview = new InputView();
    private static final int LOTTO_PRICE = 1000;
    private UserLotto userLotto;

    private void makeLotto() {
        userLotto = new UserLotto();
        int quantity = LottoQuantityCalculation();
        userLotto.setLottos(quantity);
    }

    private int LottoQuantityCalculation() {
        int userMoney = Integer.parseInt(inputview.inputUserMoney());
        return userMoney / LOTTO_PRICE;
    }
}
