package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(Lotto lotto) {
        return winningLotto.countMatchNumber(lotto);
    }

    public boolean bonus(Lotto lotto) {
        return lotto.bonus(bonusNumber);
    }

}
