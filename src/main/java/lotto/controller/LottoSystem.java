package lotto.controller;

import lotto.domain.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystem {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final int LOTTO_PRICE = 1000;

    public void startLottoSystem() {
        int userMoney = Integer.parseInt(inputView.inputUserMoney());
        int lottoQuantity = LottoQuantityCalculation(userMoney);
        outputView.printQuantity(lottoQuantity);
        UserLotto userLotto = makeUserLottos(lottoQuantity);
        outputView.printLottoNumber(userLotto);
    }

    public UserLotto makeUserLottos(int lottoQuantity) {
        UserLotto userLotto = new UserLotto();
        userLotto.setLottos(lottoQuantity);
        return userLotto;
    }

    public int LottoQuantityCalculation(int userMoney) {
        return userMoney / LOTTO_PRICE;
    }
}
