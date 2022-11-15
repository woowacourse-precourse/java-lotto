package lotto.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Rank {
    NONE(0, 0,
            (matchCount, isBonus) -> matchCount < 3),
    FIFTH(5000, 3,
            (matchCount, isBonus) -> matchCount == 3),
    FOURTH(50000, 4,
            (matchCount, isBonus) -> matchCount == 4),
    THIRD(1500000, 5,
            (matchCount, isBonus) -> matchCount == 5 && !isBonus),
    SECOND(30000000, 5,
            (matchCount, isBonus) -> matchCount == 5 && isBonus),
    FIRST(2000000000, 6,
            (matchCount, isBonus) -> matchCount == 6);

    private final int prize;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(final int prize, final int matchCount, BiPredicate<Integer, Boolean> condition) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.condition = condition;
    }

    public static Rank of(final int matchCount, final boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition.test(matchCount, isBonus))
                .findAny()
                .orElse(NONE);
    }

    public static List<Rank> getWithoutDefault() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(NONE))
                .collect(Collectors.toList());
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
