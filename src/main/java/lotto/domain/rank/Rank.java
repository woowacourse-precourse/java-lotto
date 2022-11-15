package lotto.domain.rank;

import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {

    FIRST(2_000_000_000, 6, (matchCount, matchBonus) -> matchCount == 6),
    SECOND(30_000_000, 5, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    THIRD(1_500_000, 5, (matchCount, matchBonus) -> matchCount == 5),
    FOURTH(50_000, 4, (matchCount, matchBonus) -> matchCount == 4),
    FIFTH(5_000, 3, (matchCount, matchBonus) -> matchCount == 3),
    UNWINNABLE(0, 0, (matchCount, matchBonus) -> matchCount < 3),
    ;

    private static final String MATCH_COUNT_ILLEGAL_ERROR_MESSAGE = "matchCount는 6 이하의 숫자여야 합니다.";

    private final Money reward;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> match;

    Rank(final int reward, final int matchCount, final BiPredicate<Integer, Boolean> match) {
        this.reward = Money.valueOf(reward);
        this.matchCount = matchCount;
        this.match = match;
    }

    public static Rank matchRank(final int matchCount, final boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.match.test(matchCount, matchBonus))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(MATCH_COUNT_ILLEGAL_ERROR_MESSAGE));
    }

    public Money getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
