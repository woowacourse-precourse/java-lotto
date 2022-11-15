package lotto.controller;

import lotto.domain.EntireLotto;
import lotto.domain.PaymentLottoMoney;
import lotto.view.inputView.MoneyInputView;

public class BuyLottoController {
    public EntireLotto buyLotto() {
        int lottoCount = calculatePossibleBuyLottoNumber();
        EntireLotto entireLotto = new EntireLotto();
        entireLotto.generateEntireLotto(lottoCount);
        entireLotto.showEntireLottoInfo();
        return entireLotto;
    }

    private int calculatePossibleBuyLottoNumber() {
        String paymentMoney = MoneyInputView.inputMoney();
        return new PaymentLottoMoney(paymentMoney).calculateNumberOfLotto();
    }
}
