package lotto.controller;

import lotto.domain.*;
import lotto.validator.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Const.*;

public class GameController {

    public void run() {
        int inputMoney = InputView.getUserMoney();
        LottoMachine lottos = buyLotto(inputMoney);
        User user = new User(inputMoney, lottos.getLottos());
    }

    public LottoMachine buyLotto(int money) {
        MoneyValidator.check(money);
        int count = money / LOTTO_PRICE_UNIT;

        LottoMachine lottos = new LottoMachine(count);
        OutputView.showLottos(lottos);
        return lottos;
    }
}
