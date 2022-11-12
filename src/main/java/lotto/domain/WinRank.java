package lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum WinRank {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    FAIL(0, 0);

    private final Integer prize;
    private final Integer matched;

    WinRank(final Integer prize, final Integer matched) {
        this.prize = prize;
        this.matched = matched;
    }

    public Integer getPrize() {
        return prize;
    }

    public Integer getMatched() {
        return matched;
    }

    public static WinRank calculateRankOfLotto(Lotto lotto, Lotto winLotto, Integer bonusNumber) {
        final Integer matched = getMatchedOfLotto(lotto, winLotto);

        if (matched.equals(SECOND.matched) && lotto.isContain(bonusNumber)) {
            return SECOND;
        }

        return Arrays.stream(WinRank.values())
                .filter(rank -> rank.matched.equals(matched))
                .findAny().orElse(FAIL);
    }

    public static Integer getMatchedOfLotto(Lotto lotto, Lotto winLotto) {
        return (int) winLotto.getLotto().stream()
                .filter(lotto.getLotto()::contains).count();
    }
}
