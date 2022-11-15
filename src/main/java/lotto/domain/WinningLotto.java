package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(Lotto lotto) {
        return winningLotto.countMatchNumber(lotto);
    }

    public boolean bonus(Lotto lotto) {
        return lotto.bonus(bonusNumber);
    }

}
