package domain.bonus;

import domain.lotto.Lotto;

public class BonusService {
    public Bonus createBonus(String bonusNumber, Lotto lotto) {
        return new Bonus(Integer.parseInt(bonusNumber), lotto);
    }
}
