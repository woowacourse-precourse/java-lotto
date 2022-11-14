package lotto.domain.match;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Reward {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    private final long reward;
    private final int match;
    private final boolean requireBonus;

    Reward(int match, long reward, boolean requireBonus) {
        this.reward = reward;
        this.match = match;
        this.requireBonus = requireBonus;
    }

    private static final Map<Integer, Reward> MATCH_TO_NON_REQUIRE_BONUS_REWARD =
            Stream.of(values())
                    .filter(Predicate.not(Reward::isRequireBonus))
                    .collect(Collectors.toUnmodifiableMap(
                            Reward::getMatch, Function.identity()));

    public static Reward find(int match, boolean isBonusMatched) {
        if (isBonusMatched && match == SECOND.match) {
            return SECOND;
        }

        return MATCH_TO_NON_REQUIRE_BONUS_REWARD.get(match);
    }

    public int getMatch() {
        return match;
    }

    public long getReward() {
        return reward;
    }

    public boolean isRequireBonus() {
        return requireBonus;
    }
}
