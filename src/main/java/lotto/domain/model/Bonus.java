package lotto.domain.model;

import static lotto.utils.Advice.BonusValidator.validateBonusNumber;

public class Bonus {

    private final Integer bonus;

    public Bonus(FirstPlace firstPlace, String bonus) {
        validateBonusNumber(bonus);
        firstPlace.duplicateCheckBonusNumber(bonus);
        this.bonus = Integer.parseInt(bonus);
    }
}
