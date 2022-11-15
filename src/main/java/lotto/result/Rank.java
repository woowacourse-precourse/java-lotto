package lotto.result;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    NONE(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private final int winningMoney;
    private final int matchCount;

     Rank(int winningMoney, int matchCount) {
        this.winningMoney = winningMoney;
        this.matchCount = matchCount;
    }

    public static Rank of(int matchCount, boolean isBonus) {
        if (matchCount == 5 && isBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    public static List<Rank> getWithoutDefault() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(NONE))
                .collect(Collectors.toList());
    }
    private boolean isMatch(final int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getPrize() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
