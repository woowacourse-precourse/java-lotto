package lotto;

public enum WinStatistics {

    UNSUCCESSFUL(0, "0"),
    FIFTH(3, "5,000원"),
    FOURTH(4, "50,000원"),
    THIRD(5, "1,500,000원"),
    SECOND(5, "30,000,000원"),
    FIRST(6, "2,000,000,000원");

    private final int matchCount;
    private final String prizeMoney;

    WinStatistics(final int matchCount, final String prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinStatistics winCounter(int matchCount, boolean bonusNumber) {
        if (matchCount == WinStatistics.SECOND.matchCount) {
            return isBonusNumber(bonusNumber);
        }

        for (WinStatistics winValue : WinStatistics.values()) {
            if (winValue.matchCount == matchCount) {
                return winValue;
            }
        }
        return WinStatistics.UNSUCCESSFUL;
    }

    public static  WinStatistics isBonusNumber(boolean bonusNumber) {
        if (bonusNumber) {
            return WinStatistics.SECOND;
        }
        return WinStatistics.THIRD;
    }

}
