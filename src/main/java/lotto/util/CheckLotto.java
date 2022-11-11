package lotto.util;

import lotto.util.input.BonusNumber;
import lotto.util.input.WinNumbers;

public class CheckLotto {
    private WinNumbers winNumbers;
    private BonusNumber bonusNumber;
    private BuyLotto buyLotto;

    public CheckLotto(WinNumbers winNumbers, BonusNumber bonusNumber, BuyLotto buyLotto) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
        this.buyLotto = buyLotto;
    }
}
