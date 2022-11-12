package lotto.domain;

import lotto.util.Constant;
import lotto.util.IOMessage;
import lotto.util.RandomNumGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserLotto {
    private final LottoWrapper userLottery = new LottoWrapper();

    public UserLotto() {
        buyLotto();
        printMyLotto();
    }

    public int size() {
        return userLottery.size();
    }

    public Lotto getLottoAt(int index) {
        return userLottery.get(index);
    }

    private void printMyLotto() {
        OutputView.printIOMessage(
                IOMessage.WRITE_AMOUNT_MESSAGE
                        .mergeAndGetMessage(String.valueOf(userLottery.size()))
        );
        userLottery.printAllLotto();
    }

    private void buyLotto() {
        long count = readMoney() / Constant.MONEY_UNIT;
        while (count-- > 0) {
            userLottery.add(makeLotto());
        }
    }

    private long readMoney() {
        return InputView.readAmount();
    }

    private Lotto makeLotto() {
        return new Lotto(RandomNumGenerator.makeUniqueRandomList());
    }
}