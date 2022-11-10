package lotto.domain.lotto.service;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.verifier.InputMoneyVerifier;
import lotto.domain.view.InputView;
import lotto.global.util.Util;

public class LottoService {

    public int inputMoney() {
        int inputMoney = Util.stringToInt(InputView.getInputMoney());
        InputMoneyVerifier.isMoneyDividedBy1000(inputMoney);
        return inputMoney;
    }

    public int lottoCount(int inputMoney) {
        return inputMoney / 1000;
    }

    public Lotto randomLottoNumbers() {
        return new Lotto(Util.orderByDescForList(Util.getRandomNumbers()));
    }
}
