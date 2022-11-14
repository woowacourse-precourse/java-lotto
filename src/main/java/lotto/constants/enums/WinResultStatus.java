package lotto.constants.enums;

public enum WinResultStatus {
    FIRST(6, 2_000_000_000),
    SECOND(7, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    final int winCount;
    final int prizeMoney;

    WinResultStatus(int winCount, int prizeMoney) {
        this.winCount = winCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinResultStatus getWinResultStatus(int hitCount) {
        if (FIRST.winCount == hitCount) {
            return FIRST;
        }
        if (SECOND.winCount == hitCount) {
            return SECOND;
        }
        if (THIRD.winCount == hitCount) {
            return THIRD;
        }
        if (FOURTH.winCount == hitCount) {
            return FOURTH;
        }
        return FIFTH;
    }
}
