package lotto;

public class WinningStat {

    private final WinningType winningType;
    private final int count;

    public WinningStat(WinningType winningType, int count) {
        this.winningType = winningType;
        this.count = count;
    }

    public WinningType getWinningType() {
        return winningType;
    }

    public int getCount() {
        return count;
    }
}
