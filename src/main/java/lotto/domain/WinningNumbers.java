package lotto.domain;

public enum WinningNumbers {
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    FIVE_BONUS(5, 30000000L),
    SIX(6, 2000000000L),
    NOTHING(2,0L);

    private final int matches;
    private final long reward;

    WinningNumbers(int matches,long reward) {
        this.matches = matches;
        this.reward = reward;
    }
    public static long getMatchedReward(int matches, boolean bonusCheck) {
        if (matches == 5 && bonusCheck) {
            return FIVE_BONUS.reward;
        }

        for (WinningNumbers winningNumbers : WinningNumbers.values()) {
            if (matches == winningNumbers.matches) {
                return winningNumbers.reward;
            }
        }

        return 0L;
    }

    public static WinningNumbers getEnum(int matches, boolean bonusCheck) {
        if (matches == 5 && bonusCheck) {
            return FIVE_BONUS;
        }

        for (WinningNumbers winningNumbers : WinningNumbers.values()) {
            if (matches == winningNumbers.matches) {
                return winningNumbers;
            }
        }

        return NOTHING;
    }

    public int getMatch() {
        return matches;
    }

    public long getReward() {
        return reward;
    }
}
