package domain.Bonus;

import domain.Lotto.Lotto;

public class BonusService {
    public Bonus createBonus(String bonusNumber, Lotto lotto) {
        return new Bonus(Integer.parseInt(bonusNumber), lotto);
    }
}
