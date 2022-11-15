package lotto.domain;

import lotto.utils.LottoValidator;

public class WinningLotto {
    private final LottoNumber bonusNumber;
    private final Lotto winningLotto;

    public WinningLotto(LottoNumber bonusNumber, Lotto winningLotto) {
        LottoValidator.validateWinningLotto(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
        this.winningLotto = winningLotto;
    }

    public LottoResult makeResult(Lotto userLotto) {
        return LottoResult.valueOf(compareWithWinningLotto(userLotto), compareWithBonusLotto(userLotto));
    }

    private int compareWithWinningLotto(Lotto userLotto) {
        return (int) winningLotto.matchCount(userLotto);
    }

    private boolean compareWithBonusLotto(Lotto userLotto) {
        return userLotto.contain(bonusNumber);
    }
}
