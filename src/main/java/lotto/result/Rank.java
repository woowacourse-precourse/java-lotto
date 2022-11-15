package lotto.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    NONE("0", 0),
    FIFTH("5,000", 3),
    FOURTH("50,000", 4),
    THIRD("1,500,000", 5),
    SECOND("30,000,000", 5),
    FIRST("2,000,000,000", 6);

    private final String winningMoney;
    private final int matchCount;

     Rank(String winningMoney, int matchCount) {
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

    private boolean isMatch(int matchCount) {
        return this.matchCount == matchCount;
    }
}
