package lotto.Model;

import static lotto.Validator.checkRange;
import static lotto.Validator.checkSizeNumber;

import java.util.List;
import java.util.Objects;

public class Bonus {

    private final Integer bonus;

    public Bonus(final Integer bonus) {
        this.bonus = bonus;
    }

    public Bonus(final Lotto firstPlace, final String bonus) {
        validate(bonus);
        firstPlace.dupCheckBonusNumber(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private static void validate(final String bonus) {
        checkSizeNumber(bonus);
        checkRange(bonus);
    }

    public Boolean calMatch(final List<Integer> numbers) {
        return numbers.contains(this.bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bonus bonus1 = (Bonus) o;
        return Objects.equals(bonus, bonus1.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonus);
    }
}