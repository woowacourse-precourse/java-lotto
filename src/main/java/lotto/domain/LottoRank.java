package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST( 6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false,  50_000),
    FIFTH(3, false,  5_000),
    FAIL(0, false, 0);

    private final int matchCount;

    private final boolean bonus;

    private final int winMoney;

    LottoRank(int matchCount, boolean bonus, int winMoney) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.winMoney = winMoney;
    }

    public static LottoRank of(int result, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == result)
                .filter(lottoRank -> !lottoRank.bonus || bonus)
                .findAny()
                .orElse(FAIL);
    }

    public int findTotalMoney (int cnt) {
        return winMoney * cnt;
    }

    public boolean isBonusNumber() {
        return bonus;
    }

    public int matchCount() {
        return matchCount;
    }

    public int winMoney() {
        return winMoney;
    }
}
