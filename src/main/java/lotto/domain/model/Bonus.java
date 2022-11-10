package lotto.domain.model;

import static lotto.utils.Advice.BonusValidator.checkRange;
import static lotto.utils.Advice.BonusValidator.checkSizeAndNumber;


public class Bonus {

    private final Integer bonus;

    public Bonus(FirstPlace firstPlace, String bonus) {
        validate(bonus);
        firstPlace.duplicateCheckBonusNumber(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private static void validate(String bonus) {
        checkSizeAndNumber(bonus);
        checkRange(bonus);
    }
}
