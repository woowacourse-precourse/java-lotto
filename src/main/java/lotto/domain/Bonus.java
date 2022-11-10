package lotto.domain;

import static lotto.utils.BonusValidator.validateBonusNumber;

public class Bonus {

    private final Integer bonus;

    public Bonus(FirstPlace firstPlace, String bonus) {
        validateBonusNumber(bonus);
        firstPlace.duplicateCheckBonusNumber(bonus);
        this.bonus = Integer.parseInt(bonus);
    }
}
