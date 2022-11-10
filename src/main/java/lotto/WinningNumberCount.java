package lotto;

public class WinningNumberCount {

    private int winningCount;
    private boolean isMatchBonusNumber;

    public WinningNumberCount(int winningCount, boolean isMatchBonusNumber) {
        this.winningCount = winningCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public static WinningNumberCount of(int winningCount, boolean isMatchBonusNumber) {
        return new WinningNumberCount(winningCount, isMatchBonusNumber);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isMatchBonusNumber() {
        return isMatchBonusNumber;
    }
}
