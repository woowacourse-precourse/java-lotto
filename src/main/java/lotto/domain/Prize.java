package lotto.domain;

import static lotto.view.Constants.*;

public enum Prize {
    FIFTH(5_000, SAME_THREE),
    FOURTH(50_000, SAME_FOUR),
    THIRD(1_500_000, SAME_FIVE),
    SECOND(30_000_000, SAME_FIVE_BONUS),
    FIRST(2_000_000_000, SAME_SIX);

    private final int prizeMoney;
    private final String prizeNotice;

    Prize(int prizeMoney, String prizeNotice) {
        this.prizeMoney = prizeMoney;
        this.prizeNotice = prizeNotice;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeNotice() {
        return prizeNotice;
    }
}
