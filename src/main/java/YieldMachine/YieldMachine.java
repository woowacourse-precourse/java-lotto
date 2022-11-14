package YieldMachine;

import User.User;
import lotto.BoughtLotto;
import lotto.WinningNumberLotto;

import java.util.ArrayList;
import java.util.List;

public class YieldMachine {

    WinningNumberLotto winningNumberLotto;
    static final Integer MAX_COUNT_OF_LOTTO_NUMBER = 6;
    List<Integer> countOfReward;

    public YieldMachine() {
        this.winningNumberLotto = new WinningNumberLotto();
        this.countOfReward = new ArrayList<>();
    }

    public void run() {

    }

    public void calculateYield(User user) {

    }

    private void calculateOneLottoReward(BoughtLotto boughtLotto) {

    }

    private void calculateAllLottoReward(List<BoughtLotto> boughtLottos) {

    }

    private int findCountOfSameNumberWithWinningNumber() {
        return 1;
    }

    private void printYield() {

    }
}
