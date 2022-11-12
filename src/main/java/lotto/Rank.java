package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    DEFAULT(0, false, 0);


    private int hitCount;
    private boolean bonusHit;
    private int prizeMoney;


    Rank(int hitCount, boolean bonusHit, int prizeMoney) {
        this.hitCount = hitCount;
        this.bonusHit = bonusHit;
        this.prizeMoney = prizeMoney;
    }


    public static Rank getWinning(int hitCount, boolean bonusHit) {
        return Arrays.stream(Rank.values())
                .filter(lottoResult -> lottoResult.hitCount == hitCount
                        && lottoResult.bonusHit == bonusHit)
                .findAny()
                .orElse(DEFAULT);
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getHitCount() {
        return this.hitCount;
    }

    public boolean getBonusHit() {
        return this.bonusHit;
    }

}