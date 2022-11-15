package Info;

public enum WinningStatus {
    THREE(0,3, 5_000L),
    FOUR(1,4, 50_000L),
    FIVE(2,5, 1_500_000L),
    FIVEPLUS(3,15, 30_000_000L),
    SIZ(4,6, 2_000_000_000L);

    private final int pointIndex;
    private final int correctPoint;
    private final Long winningMoney;

    WinningStatus(int pointIndex, int correctPoint, Long winningMoney) {
        this.pointIndex = pointIndex;
        this.correctPoint = correctPoint;
        this.winningMoney = winningMoney;
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

    public static WinningStatus getWinningStatus(int point) {
        for (WinningStatus winningIndex : WinningStatus.values()) {
            if (winningIndex.correctPoint == point) {
                return winningIndex;
            }
        }

        throw new IllegalArgumentException(PrintGameInfo.getPointError());
    }
}
