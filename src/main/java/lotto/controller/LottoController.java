package lotto.controller;

import lotto.domain.User;
import lotto.view.InputView;

public class LottoController {

    User user = new User();

    public void buyLotto() {
        int money = Integer.parseInt(InputView.inputMoney());
        user = User.initUserLotto(money);
    }
}
