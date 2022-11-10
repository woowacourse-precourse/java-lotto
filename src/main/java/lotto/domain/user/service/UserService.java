package lotto.domain.user.service;

import lotto.domain.lotto.verifier.InputMoneyVerifier;
import lotto.domain.view.InputView;
import lotto.global.util.Util;

public class UserService {
    public int inputMoney() {
        int inputMoney = Util.stringToInt(InputView.getInputMoney());
        InputMoneyVerifier.isMoneyDividedBy1000(inputMoney);
        return inputMoney;
    }
}
