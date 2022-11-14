package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST( 6,  0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0,  50_000),
    FIFTH(3, 0,  5_000),
    FAIL(0, 0, 0);

    private final int matchCount;

    private final int bonusCount;

    private final int winMoney;

    LottoRank(int matchCount, int bonusCount, int winMoney) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.winMoney = winMoney;
    }

    public static LottoRank of(int result, int bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == result)
                .filter(lottoRank -> lottoRank.bonusCount == bonus)
                .findAny()
                .orElse(FAIL);
    }

    public int findTotalMoney (int cnt) {
        return winMoney * cnt;
    }

    public boolean isBonusNumber() {
        return bonusCount == 1;
    }

    public int matchCount() {
        return matchCount;
    }

    public int winMoney() {
        return winMoney;
    }
}
