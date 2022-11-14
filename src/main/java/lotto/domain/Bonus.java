package lotto.domain;

import lotto.util.errorMessage.ErrorMessage;

public class Bonus {
    private final int bonusNum;
    private final Lotto lotto;

    public Bonus(int bonusNum, Lotto lotto) {
        validateBonusNumisDuplicate(bonusNum,lotto);
        this.bonusNum = bonusNum;
        this.lotto = lotto;
    }

    private void validateBonusNumisDuplicate(int bonusNum, Lotto lotto){
        if (lotto.getNumbers().contains(bonusNum)){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUSNUM);
        }
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
