package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOTHING(0, false, 0);

    private int hit;
    private boolean hasBonusHit;
    private int reward;

    Rank(int hit, boolean hasBonusHit, int reward) {
        this.hit = hit;
        this.hasBonusHit = hasBonusHit;
        this.reward = reward;
    }

    public static Rank of(int hit, boolean hasBonusHit) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.hit == hit)
                .filter(rank -> rank.hasBonusHit == hasBonusHit)
                .findFirst()
                .orElse(NOTHING);
    }
}
