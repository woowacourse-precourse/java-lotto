package lotto;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(-1, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    ZERO(0, 0, "");

    private final int count;
    private final long prizeWon;
    private final String prizePrint;

    Prize(int count, long prizeWon, String prizePrint) {
        this.count = count;
        this.prizeWon = prizeWon;
        this.prizePrint = prizePrint;
    }

    public static Prize findPrize(int countNum) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getCount()==countNum).findAny().orElse(ZERO);
    }

    public long getPrizeWon() {
        return prizeWon;
    }
    public String getPrizePrint() {
        return prizePrint;
    }
    public int getCount() {
        return count;
    }
}
