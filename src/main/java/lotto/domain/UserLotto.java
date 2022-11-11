package lotto.domain;

import lotto.util.Constant;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private final LottoWrapper lottoSet = new LottoWrapper();

    public void buyLotto() {
        long count = readMoney() / Constant.MONEY_UNIT;
        while (count-- > 0) {
            lottoSet.add(makeLotto());
        }
    }

    public void printMyLotto() {
        lottoSet.printAllLotto();
    }

    private long readMoney() {
        return InputView.readAmount();
    }

    private Lotto makeLotto() {
        return new Lotto(RandomNumGenerator.makeUniqueRandomList());
    }
}