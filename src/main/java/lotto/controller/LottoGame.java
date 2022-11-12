package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;

public class LottoGame {
    public void start() {
        Money money = new Money(InputView.inputPurchaseMoney());
        int lottoCount = money.countLotto();

        Lottos lottos = new Lottos(LottoGenerator.generateLottos(lottoCount));
    }
}
