package controller;

import domain.Bonus;
import domain.Lotto;
import service.BonusService;

public class BonusController {
    private final BonusService bonusService = new BonusService();

    public Bonus createBonusNumber(String bonusNumber, Lotto lotto) {
        return bonusService.createBonusNumber(Integer.parseInt(bonusNumber), lotto);
    }
}
