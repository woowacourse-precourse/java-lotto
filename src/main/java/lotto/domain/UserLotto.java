package lotto.domain;

import lotto.util.Constant;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private LottoWrapper lottoSet = new LottoWrapper();

    public void buyLottos() {
        long count = readMoney() % Constant.MONEY_UNIT;
        while (count-- > 0) {
            lottoSet.add(makeLotto());
        }
    }

    private long readMoney() {
        return InputView.readAmount();
    }

}