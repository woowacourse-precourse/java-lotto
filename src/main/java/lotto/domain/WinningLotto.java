package lotto.domain;

import lotto.view.InputView;

public class WinningLotto {
    private Lotto winningLotto;

    public WinningLotto() {
        readWinningLotto();
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    private void readWinningLotto() {
        winningLotto = new Lotto(InputView.readWinningNumber());
    }
}
