package lotto.dto;

public class WinningNumberCountDto {

    private int winningCount;
    private boolean isMatchBonusNumber;

    public WinningNumberCountDto(int winningCount, boolean isMatchBonusNumber) {
        this.winningCount = winningCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public static WinningNumberCountDto of(int winningCount, boolean isMatchBonusNumber) {
        return new WinningNumberCountDto(winningCount, isMatchBonusNumber);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isMatchBonusNumber() {
        return isMatchBonusNumber;
    }
}
