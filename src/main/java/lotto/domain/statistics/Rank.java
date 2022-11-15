package lotto.domain.statistics;

import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.Objects;

public enum Rank {

    FIRST(6, Money.create(2_000_000_000)),
    SECOND(5, Money.create(30_000_000)),
    THIRD(5, Money.create(1_500_000)),
    FOURTH(4, Money.create(50_000)),
    FIFTH(3, Money.create(5_000)),
    NOTHING(0, Money.create(0));

    private static final long SECOND_MATCH = 5;

    private final Integer match;
    private final Money reward;

    Rank(Integer match, Money reward) {
        this.match = match;
        this.reward = reward;
    }

    public static Rank from(Integer match, boolean hasBonus) {
        if (match == SECOND_MATCH) {
            return decideSecondOrThird(hasBonus);
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(match))
                .findFirst()
                .orElse(NOTHING);
    }

    private static Rank decideSecondOrThird(boolean hasBonus) {
        if (hasBonus) {
            return SECOND;
        }
        return THIRD;
    }

    private boolean isMatch(Integer match) {
        return Objects.equals(this.match, match);
    }

    public Integer getMatch() {
        return match;
    }

    public Integer getReward() {
        return reward.getMoney();
    }
}
