package lotto.domain.result;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Rank {
    NONE(0, 0,
            (ballCount, isBonus) -> ballCount < 3),
    FIFTH(5000, 3,
            (ballCount, isBonus) -> ballCount == 3),
    FOURTH(50000, 4,
            (ballCount, isBonus) -> ballCount == 4),
    THIRD(1500000, 5,
            (ballCount, isBonus) -> ballCount == 5 && !isBonus),
    SECOND(30000000, 5,
            (ballCount, isBonus) -> ballCount == 5 && isBonus),
    FIRST(2000000000, 6,
            (ballCount, isBonus) -> ballCount == 6),
    ;

    private final int prize;
    private final int ballCount;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(int prize, int ballCount, BiPredicate<Integer, Boolean> condition) {
        this.prize = prize;
        this.ballCount = ballCount;
        this.condition = condition;
    }

    public static Rank of(int ballCount, boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition.test(ballCount, isBonus))
                .findAny()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public int getBallCount() {
        return ballCount;
    }

    public static List<Rank> getAllRank() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(NONE))
                .collect(Collectors.toList());
    }
}
