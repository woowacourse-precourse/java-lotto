package lotto.domain;

import java.util.Arrays;

public enum Rank {
    ZERO(0, 0, false),
    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 1_500_000, false),
    FIVEWITHBONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false);

    private int countOfMatch;
    private int reward;
    private boolean isMatchedBonus;

    Rank(int countOfMatch, int reward, boolean isMatchedBonus) {
        this.countOfMatch = countOfMatch;
        this.reward = reward;
        this.isMatchedBonus = isMatchedBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getReward() {
        return reward;
    }

    public boolean isMatchedBonus() {
        return isMatchedBonus;
    }

    public static Rank makeRank(int countOfMatch, boolean isMatchedBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .filter(rank -> {
                    if (rank.countOfMatch != 5) {
                        return true;
                    }
                    return rank.isMatchedBonus == isMatchedBonus;
                })
                .findAny()
                .orElse(ZERO);
    }
}
