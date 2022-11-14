package lotto.model;

import java.util.Objects;

public class CompareResult {
    private final int winningNumbersMatchCount;
    private final boolean hasBonus;

    public CompareResult(int winningNumbersMatchCount, boolean hasBonus) {
        this.winningNumbersMatchCount = winningNumbersMatchCount;
        this.hasBonus = hasBonus;
    }

    public static CompareResult getDefault() {
        return new CompareResult(0, false);
    }

    public CompareResult oneMoreNumberMatched() {
        return new CompareResult(winningNumbersMatchCount + 1, hasBonus);
    }

    public CompareResult bonusNumberFound() {
        return new CompareResult(winningNumbersMatchCount, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompareResult other = (CompareResult) o;
        return winningNumbersMatchCount == other.winningNumbersMatchCount && hasBonus == other.hasBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbersMatchCount, hasBonus);
    }
}
