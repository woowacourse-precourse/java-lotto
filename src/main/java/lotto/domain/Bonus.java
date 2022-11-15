package lotto.domain;

import lotto.util.errorMessage.ErrorMessage;

public class Bonus {

    public final int bonusNum;
    private final Lotto winninglotto;

    public Bonus(int bonusNum, Lotto winninglotto) {
        validateBonusNumisDuplicate(bonusNum, winninglotto);
        this.bonusNum = bonusNum;
        this.winninglotto = winninglotto;
    }

    private void validateBonusNumisDuplicate(int bonusNum, Lotto winninglotto) {
        if (Lotto.isWinningLottoHasBouns(bonusNum, winninglotto)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUSNUM);
        }
    }
}
