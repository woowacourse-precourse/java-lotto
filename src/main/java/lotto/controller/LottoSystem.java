package lotto.controller;

import lotto.domain.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystem {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final int LOTTO_PRICE = 1000;
    private UserLotto userLotto;

    public void startLottoSystem() {
        int lottoQuantity = LottoQuantityCalculation();
        outputView.printQuantity(lottoQuantity);
        makeUserLottos(lottoQuantity);

    }

    private void makeUserLottos(int lottoQuantity) {
        userLotto = new UserLotto();
        userLotto.setLottos(lottoQuantity);
    }

    private int LottoQuantityCalculation() {
        int userMoney = Integer.parseInt(inputView.inputUserMoney());
        return userMoney / LOTTO_PRICE;
    }
}
