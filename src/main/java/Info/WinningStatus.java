package Info;

public enum WinningStatus {
    THREE(0,3, 5_000L, "3개 일치 (5,000원)"),
    FOUR(1,4, 50_000L, "4개 일치 (50,000원)"),
    FIVE(2,5, 1_500_000L, "5개 일치 (1,500,000원)"),
    FIVEPLUS(3,15, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(4,6, 2_000_000_000L, "6개 일치 (2,000,000,000원)");

    private final int pointIndex;
    private final int correctPoint;
    private final Long winningMoney;
    private final String printInfo;

    WinningStatus(int pointIndex, int correctPoint, Long winningMoney, String printInfo) {
        this.pointIndex = pointIndex;
        this.correctPoint = correctPoint;
        this.winningMoney = winningMoney;
        this.printInfo = printInfo;
    }

    public int getCorrectPoint() {
        return correctPoint;
    }

    public Long getWinningMoney() {
        return winningMoney;
    }

    public int getPointIndex() {
        return pointIndex;
    }

    public String getPrintInfo() {
        return printInfo;
    }

    public static WinningStatus getWinningStatusWithPoint(int point) {
        for (WinningStatus winningIndex : WinningStatus.values()) {
            if (winningIndex.correctPoint == point) {
                return winningIndex;
            }
        }

        throw new IllegalArgumentException(PrintGameInfo.getPointError());
    }

    public static WinningStatus getWinningStatusWithIndex(int index) {
        for (WinningStatus winningIndex : WinningStatus.values()) {
            if (winningIndex.pointIndex == index) {
                return winningIndex;
            }
        }
        throw new IllegalArgumentException(PrintGameInfo.getPointError());
    }
}
