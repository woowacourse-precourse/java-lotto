package lotto.domain.lotto.service;

import lotto.domain.lotto.domain.Lotto;
import lotto.domain.view.InputView;
import lotto.global.util.Util;

public class LottoService {

    public int lottoCount(int inputMoney) {
        return inputMoney / 1000;
    }

    public Lotto randomLottoNumbers() {
        return new Lotto(Util.orderByDescForList(Util.getRandomNumbers()));
    }

    public Lotto prizeLotto() {
        return new Lotto(Util.inputNumbersInList());
    }

    public void bonusNumber() {
        InputView.getInputBonusNumber();
    }
}
