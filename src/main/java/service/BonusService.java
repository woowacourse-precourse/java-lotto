package service;

import domain.Bonus;
import domain.Lotto;

public class BonusService {
    public Bonus createBonusNumber(int bonusNumber, Lotto lotto) {
        return new Bonus(bonusNumber);
    }
}
