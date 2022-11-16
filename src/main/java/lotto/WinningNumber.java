package lotto;

import java.util.List;

public class WinningNumber {
    private Lotto lotto;
    private int bonus;

    public WinningNumber(Lotto lotto, int bonus) {
        validateBonusNumberRange(bonus);
        validateBonusNumberDuplicated(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validateBonusNumberRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR]: bonus number range error");
        }
    }

    private void validateBonusNumberDuplicated(Lotto lotto, int bonus) {
        for (int lottoNumber : lotto.getNumbers()) {
            if (bonus == lottoNumber) {
                throw new IllegalArgumentException("[ERROR]: duplicated bonus number error");
            }
        }
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public int getBonus() {
        return this.bonus;
    }

}
