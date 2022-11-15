package lotto.model;

import java.util.Objects;

public class Result {
    private final int match;
    private final boolean bonus;

    public Result(int match, boolean bonus) {
        this.match = match;
        this.bonus = bonus;
    }

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result compareResult = (Result) o;
        return Objects.equals(match, compareResult.match) && Objects.equals(bonus, compareResult.bonus);
    }
}
