package lotto.domain.rank;

import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {

    FIRST(2_000_000_000, (matchCount, matchBonus) -> matchCount == 6),
    SECOND(30_000_000, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    THIRD(1_500_000, (matchCount, matchBonus) -> matchCount == 5),
    FOURTH(50_000, (matchCount, matchBonus) -> matchCount == 4),
    FIFTH(5_000, (matchCount, matchBonus) -> matchCount == 3),
    UNWINNABLE(0, (matchCount, matchBonus) -> matchCount < 3),
    ;

    private final Money reward;
    private final BiPredicate<Integer, Boolean> match;

    Rank(int reward, BiPredicate<Integer, Boolean> match) {
        this.reward = Money.valueOf(reward);
        this.match = match;
    }

    public Money getReward() {
        return reward;
    }

    public static Rank matchRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.match.test(matchCount, matchBonus))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("matchCount는 6 이하의 숫자여야 합니다."));
    }
}
