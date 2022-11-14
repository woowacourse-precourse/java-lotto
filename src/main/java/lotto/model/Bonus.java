package lotto.model;

import lotto.Env;
import lotto.util.Lang;
import lotto.util.Validator;

public class Bonus {
    private final int bonus;

    public Bonus(int bonus) {
        this.validate(bonus);
        this.bonus = bonus;
    }

    public int toInt() {
        return this.bonus;
    }

    private void validate(int bonus) {
        this.validateCorrectRangeNumber(bonus);
    }

    private void validateCorrectRangeNumber(int bonus) {
        if (Validator.hasNotCorrectRangeNumber(bonus)) {
            throw new IllegalArgumentException(Lang.format(
                    Lang.OUT_RANGE,
                    Env.LOTTO_FIRST_NUMBER,
                    Env.LOTTO_LAST_NUMBER
            ));
        }
    }
}
