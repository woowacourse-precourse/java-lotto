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
}
