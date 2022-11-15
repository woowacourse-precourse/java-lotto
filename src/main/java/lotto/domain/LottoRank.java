package lotto.domain;

import java.text.NumberFormat;
import java.util.Arrays;

public enum LottoRank {

    NOTING(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private final int prizeMoney;
    private final int matchCount;
    private final boolean hasBonusNumber;

    LottoRank(int prizeMoney, int matchCount, boolean hasBonusNumber) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoRank getRank(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(NOTING);
    }

    public String getPrizeMoney() {
        return NumberFormat.getInstance().format(prizeMoney);
    }
}
