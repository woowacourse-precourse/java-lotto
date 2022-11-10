package lotto;

import java.util.Objects;

public class Result {
    int matchCount = 0;
    boolean hasBonusNumber = false;

    public Result(int matchCount, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public Result(WinLotto winLotto, Lotto generatedLotto) {
        for (Integer number : generatedLotto.getNumbers()) {
            hasMatchNumber(winLotto, number);
        }
        if (generatedLotto.getNumbers().contains(winLotto.bonusNumber)) {
            hasBonusNumber = true;
        }
    }

    private void hasMatchNumber(WinLotto winLotto, Integer number) {
        if (winLotto.getNumbers().contains(number)) {
            matchCount++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return matchCount == result.matchCount && hasBonusNumber == result.hasBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, hasBonusNumber);
    }
}
