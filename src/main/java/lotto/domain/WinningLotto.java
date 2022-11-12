package lotto.domain;

import lotto.exception.domain.WinningLottoNumberDuplicateException;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.isContainNumber(bonusNumber)) {
            throw new WinningLottoNumberDuplicateException();
        }
    }

    public Rank rank(Lotto matchLotto) {
        return Rank.result(this.lotto.matchCount(matchLotto), matchLotto.isContainNumber(this.bonusNumber));
    }
}
