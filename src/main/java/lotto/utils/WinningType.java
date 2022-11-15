package lotto.utils;

public enum WinningType {
    NOTHING("없음", 0, 0),
    FIVE_PLACE("3개 일치 (5,000원)", 3, 5_000),
    FOURTH_PLACE("4개 일치 (50,000원)", 4, 50_000),
    THIRD_PLACE("5개 일치 (1,500,000원)", 5, 1_500_000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, 30_000_000),
    FIRST_PLACE("6개 일치 (2,000,000,000원)", 6, 2_000_000_000);

    private final String result;
    private final long matchCount;
    private final int winningAmount;

    WinningType(String result, long matchCount, int winningAmount) {
        this.result = result;
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }


    private static WinningType ofMatchBonus(boolean matchBonus) {
        if (matchBonus) {
            return SECOND_PLACE;
        }
        return THIRD_PLACE;
    }

    public String getResult() {
        return result;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}


