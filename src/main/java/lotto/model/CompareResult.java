package lotto.model;

import java.util.Objects;

public class CompareResult {
    private final int matchCount;
    private final boolean hasBonus;
    public CompareResult(int matchCount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public CompareResult increaseMatchCount() {
        return new CompareResult(matchCount + 1, hasBonus);
    }

    public CompareResult bonusNumberFound() {
        return new CompareResult(matchCount, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompareResult that = (CompareResult) o;
        return matchCount == that.matchCount && hasBonus == that.hasBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, hasBonus);
    }
}
