package lotto.domain;

import lotto.view.InputView;

import java.util.Arrays;

public class WinningLotto {
    private Lotto winningLotto;

    public WinningLotto() {
        readWinningLotto();
    }

    public int grade(Lotto lotto) {
        return winningLotto.compare(lotto);
    }

    private void readWinningLotto() {
        winningLotto = new Lotto(InputView.readWinningNumber());
    }
}
