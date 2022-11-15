package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(2000000000, 6, (count, bonus) -> count == 6),
    SECOND_BONUS(30000000, 5, (count, bonus) -> count == 5 && bonus),
    SECOND(1500000, 5, (count, bonus) -> count == 5),
    FOURTH(50000, 4, (count, bonus) -> count == 4),
    FIFTH(5000, 3, (count, bonus) -> count == 3),
    SIX(0, 0, (count, bonus) -> count < 3);

    private final int reward;
    private final int count;
    private final BiPredicate<Integer, Boolean> compare;

    Rank(int reward, final int count, BiPredicate<Integer, Boolean> compare) {
        this.reward = reward;
        this.count = count;
        this.compare = compare;
    }

    public static Rank calculateRank(int count, boolean bonus) {
        return Arrays.stream(Rank.values()).
                filter(rank -> rank.compare.test(count, bonus))
                .findAny().get();
    }

    public int getReward() {
        return reward;
    }

    public int getCount() {
        return count;
    }
}
