package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum Winning {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THRID(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);


    private int hitCount;
    private boolean bonusHit;
    private int prizeMoney;

    Winning(int hitCount, boolean bonusHit, int prizeMoney) {
        this.hitCount = hitCount;
        this.bonusHit = bonusHit;
        this.prizeMoney = prizeMoney;
    }


    public static Winning getWinning(int hitCount, boolean bonusHit) {
        return Arrays.stream(Winning.values())
                .filter(lottoResult -> lottoResult.hitCount == hitCount
                                && lottoResult.bonusHit == bonusHit)
                .findAny()
                .get();
    }
}