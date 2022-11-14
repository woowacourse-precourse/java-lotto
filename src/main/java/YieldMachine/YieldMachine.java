package YieldMachine;

import User.User;
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

    private void calculateOneLottoReward() {

    }

    private void calculateAllLottoReward() {

    }

    private int findCountOfSameNumberWithWinningNumber() {
        return 1;
    }

    private void printYield() {

    }
}
