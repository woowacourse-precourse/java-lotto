package lotto.domain;

import lotto.util.Constant;
import lotto.util.IOMessage;
import lotto.util.RandomNumGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserLotto {
    private final LottoWrapper lottoSet = new LottoWrapper();

    public UserLotto() {
        buyLotto();
        printMyLotto();
    }

    public int size() {
        return lottoSet.size();
    }

    public Lotto getLottoAt(int index) {
        return lottoSet.get(index);
    }

    private void printMyLotto() {
        OutputView.printIOMessage(
                IOMessage.WRITE_AMOUNT_MESSAGE
                        .mergeAndGetMessage(String.valueOf(lottoSet.size()))
        );
        lottoSet.printAllLotto();
    }

    private void buyLotto() {
        long count = readMoney() / Constant.MONEY_UNIT;
        while (count-- > 0) {
            lottoSet.add(makeLotto());
        }
    }

    private long readMoney() {
        return InputView.readAmount();
    }

    private Lotto makeLotto() {
        return new Lotto(RandomNumGenerator.makeUniqueRandomList());
    }
}