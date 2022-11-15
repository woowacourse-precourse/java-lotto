package lotto.domain.getwin.domain;

import static lotto.constant.ErrorMessage.ERROR_BONUS_OUT_OF_RANGE;
import static lotto.constant.Integer.BONUS_NUMBER_MAX;
import static lotto.constant.Integer.BONUS_NUMBER_MIN;

public class Bonus {
    public final int bonus;

    public Bonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        if (!numbersInRange(bonus)) {
            throw new IllegalArgumentException(ERROR_BONUS_OUT_OF_RANGE);
        }
    }

    private boolean numbersInRange(int bonus) {
        return ((bonus >= BONUS_NUMBER_MIN) && (bonus <= BONUS_NUMBER_MAX));
    }
}
