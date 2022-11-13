package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.lotto = winningLotto;
        winningLotto.validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto numbers() {
        return lotto;
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
