package lotto.domain.model;

import static lotto.utils.Advice.BonusValidator.checkBonusSizeAndConsistNumber;


public class Bonus {

    private final Integer bonus;

    public Bonus(FirstPlace firstPlace, String bonus) {
        validate(bonus);
        firstPlace.duplicateCheckBonusNumber(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    public static void validate(String bonus) {
        checkBonusSizeAndConsistNumber(bonus);
    }
}
