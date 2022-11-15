package lotto.domain.lotto;

import lotto.exception.lotto.BonusNumDuplicatedException;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(final Lotto lotto, final LottoNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final Lotto lotto, final LottoNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    private static void validate(final Lotto lotto, final LottoNumber number) {
        if (lotto.contains(number)) {
            throw new BonusNumDuplicatedException(number.get());
        }
    }

    public boolean contains(final LottoNumber number) {
        return lotto.contains(number);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}