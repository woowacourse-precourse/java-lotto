package lotto.domain;


public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        return lotto.containsCount(winningLotto);
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
