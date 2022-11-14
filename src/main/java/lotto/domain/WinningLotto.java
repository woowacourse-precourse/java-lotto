package lotto.domain;

public class WinningLotto {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}
