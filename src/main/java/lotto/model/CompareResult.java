package lotto.model;

import java.util.Objects;

public class CompareResult {
    private final int match;
    private final boolean hasBonus;
    public CompareResult(int match, boolean hasBonus) {
        this.match = match;
        this.hasBonus = hasBonus;
    }

    public CompareResult increaseMatch() {
        return new CompareResult(match + 1, hasBonus);
    }

    public CompareResult foundBonusNumber() {
        return new CompareResult(match, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompareResult that = (CompareResult) o;
        return match == that.match && hasBonus == that.hasBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, hasBonus);
    }
}
