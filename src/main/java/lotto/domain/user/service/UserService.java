package lotto.domain.user.service;

import lotto.domain.lotto.verifier.InputMoneyVerifier;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;
import lotto.global.util.Util;

public class UserService {
    public int inputMoney() {
        InputMoneyVerifier.inputMoneyVerifier(InputView.getInputMoney());
        int inputMoney = Util.stringToInt(InputView.getInputMoney());
        OutputView.enter();
        return inputMoney;
    }
}
