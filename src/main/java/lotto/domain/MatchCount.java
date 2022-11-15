package lotto.domain;

import static constant.Constant.*;

public class MatchCount {
    private int winningCount;
    private int bonusCount;

    public MatchCount(int winningCount, int bonusCount) {
        valid(winningCount, bonusCount);
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
    }

    private void valid(int winningCount, int bonusCount) {
        if (winningCount < INITIAL_NUMBER || winningCount > LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        if (bonusCount < INITIAL_NUMBER || bonusCount > BONUS_SIZE) {
            throw new IllegalArgumentException();
        }
        if (winningCount + bonusCount > LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isSameResult(MatchCount compareObject) {
        if (winningCount != compareObject.winningCount) {
            return false;
        }
        if (winningCount != 5 || bonusCount == compareObject.bonusCount) {
            return true;
        }
        return false;
    }
}
