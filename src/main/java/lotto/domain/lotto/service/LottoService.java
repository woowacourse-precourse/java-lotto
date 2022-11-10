package lotto.domain.lotto.service;

import lotto.domain.lotto.verifier.InputMoneyVerifier;
import lotto.domain.view.InputView;
import lotto.global.util.Util;

public class LottoService {

    public int getInputMoney() {
        int inputMoney = Util.stringToInt(InputView.getInputMoney());
        InputMoneyVerifier.isMoneyDividedBy1000(inputMoney);
        return inputMoney;
    }
}
