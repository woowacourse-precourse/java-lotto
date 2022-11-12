package lotto.domain;

import java.util.List;

public class LottoMachine {

    private LottoGroups lottoGroups;
    private WinningLotto winningLotto;
    private int count;

    public LottoMachine(int count) {

    }

    private void createLotto() {

    }

    public void saveWinningNumber(List<Integer> numbers, int bonusNumber) {

    }

    private void createRandomNumbers() {

    }

    private boolean checkDuplication() {
        return true;
    }

    public List<Integer> getWinningList() {

        return List.of(1, 2, 3, 4, 5);
    }

    private boolean checkWinningNumber() {
        return true;
    }

    public double getYield() {
        return 1.0;
    }

}
