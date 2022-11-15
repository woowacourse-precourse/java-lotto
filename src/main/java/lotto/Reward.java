package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Reward {
    NONE(0, 0, (sameCount, isBonus) -> sameCount < 3),
    FIFTH(5000, 3,
            (sameCount, isBonus) -> sameCount == 3),
    FOURTH(50000, 4,
            (sameCount, isBonus) -> sameCount == 4),
    THIRD(1500000, 5,
            (sameCount, isBonus) -> sameCount == 5 && !isBonus),
    SECOND(30000000, 5,
            (sameCount, isBonus) -> sameCount == 5 && isBonus),
    FIRST(2000000000, 6,
            (sameCount, isBonus) -> sameCount == 6);

    private final int prize;
    private final int sameCount;
    private final BiPredicate<Integer, Boolean> condition;

    Reward(int prize, int sameCount, BiPredicate<Integer, Boolean> condition) {
        this.prize = prize;
        this.sameCount = sameCount;
        this.condition = condition;
    }

    public static Reward of(int sameCount, boolean isBonus) {
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.condition
                        .test(sameCount, isBonus))
                .findAny()
                .orElse(NONE);
    }

    public static List<Reward> getWithoutDefault() {
        return Arrays.stream(Reward.values())
                .filter(rank -> !rank.equals(NONE))
                .collect(Collectors.toList());
    }

    public int getPrize() {
        return prize;
    }

    public int getSameCount() {
        return sameCount;
    }
}
