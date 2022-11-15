package lotto.domain;

public enum WinStatus {

    NOTHING(0,0,0),
    THREE_MATCH(1,3, 5000),
    FOUR_MATCH(2, 4, 50000),
    FIVE_MATCH(3, 5, 1500000),
    FIVE_BONUS_MATCH(4,5,30000000),
    SIX_MATCH(5,6,2000000000);

    private final int index;
    private final int matchCount;
    private final long prize;

    WinStatus(int index, int matchCount, long prize) {
        this.index = index;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getIndex() {
        return index;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    // 인덱스 입력하면 상금 반환 기능
    public static long getPrizeMoney(int index) {
        for (WinStatus winStatus : WinStatus.values()) {
            if (winStatus.getIndex() == index) {
                return winStatus.getPrize();
            }
        }
        return NOTHING.prize;
    }

    // 당첨된 숫자 입력하면 해당 enum반환 기능
    public static WinStatus getWinStatus(int number) {
        for (WinStatus winStatus : WinStatus.values()) {
            if (winStatus.getMatchCount() == number) {
                return winStatus;
            }
        }
        return NOTHING;
    }
}
