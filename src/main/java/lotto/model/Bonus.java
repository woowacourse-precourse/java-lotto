package lotto.model;

import lotto.Env;
import lotto.util.Lang;
import lotto.util.Validator;

public class Bonus {
    private final int bonus;

    public static Bonus from(String input) {
        try {
            return new Bonus(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Lang.THROW_NON_NUMERIC_CHARACTER);
        }
    }

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
                    Lang.THROW_OUT_RANGE,
                    Env.LOTTO_FIRST_NUMBER,
                    Env.LOTTO_LAST_NUMBER
            ));
        }
    }
}
