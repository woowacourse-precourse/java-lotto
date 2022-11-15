package lotto;

import static lotto.exception.ExceptionCode.ALREADY_PICKED_BONUS_NUMBER;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto lotto, LottoNumber bonusNo) {
        validateLottoNumbersContainBonusNumber(lotto, bonusNo);
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    private void validateLottoNumbersContainBonusNumber(Lotto winningLotto, LottoNumber bonusNo) {
        if (winningLotto.isContains(bonusNo)) {
            throw new IllegalArgumentException(ALREADY_PICKED_BONUS_NUMBER);
        }
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.countOfMatch(lotto);
        boolean matchBonus = userLotto.isContains(bonusNo);
        return Rank.findBy(countOfMatch, matchBonus);
    }
}
