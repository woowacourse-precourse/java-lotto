package lotto.domain;

import lotto.view.InputView;

public class WinningLotto {
    private Lotto winningLotto;

    public void readWinningLotto() {
        winningLotto = new Lotto(InputView.readWinningNumber());
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
