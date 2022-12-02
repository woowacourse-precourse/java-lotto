package lotto.model.result;

import java.util.Arrays;
import java.util.List;

public enum WinningRank {

    FIRST(6, List.of(true, false), 2_000_000_000),
    SECOND(5, List.of(true), 30_000_000),
    THIRD(5, List.of(false), 1_500_000),
    FOURTH(4, List.of(true, false), 50_000),
    FIFTH(3, List.of(true, false), 5_000),
    NONE(1, List.of(true, false), 0);


    private final int match;
    private final List<Boolean> hasBonus;
    private final int cashPrize;

    WinningRank(int match, List<Boolean> hasBonus, int cashPrize) {
        this.match = match;
        this.hasBonus = hasBonus;
        this.cashPrize = cashPrize;
    }

    public static WinningRank from(int match, boolean hasBonus) {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank.match == match)
                .filter(rank -> rank.hasBonus.contains(hasBonus))
                .findAny()
                .orElse(NONE);
    }

    public int getMatch() {
        return match;
    }

    public int getCashPrize() {
        return cashPrize;
    }
}
