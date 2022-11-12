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
        int userMoney = Integer.parseInt(inputView.inputUserMoney());
        int lottoQuantity = LottoQuantityCalculation(userMoney);
        outputView.printQuantity(lottoQuantity);
        makeUserLottos(lottoQuantity);
        outputView.printLottoNumber(userLotto);
    }

    public void makeUserLottos(int lottoQuantity) {
        userLotto = new UserLotto();
        userLotto.setLottos(lottoQuantity);
    }

    public int LottoQuantityCalculation(int userMoney) {
        return userMoney / LOTTO_PRICE;
    }
}
