package lotto.constant;

public enum WinningConstants {

    private final int requiredWinningNumber;
    private final boolean hasBonusNumber;
    private final int reward;

    WinningConstants(int requiredWinningNumber, boolean hasBonusNumber, int reward) {
        this.requiredWinningNumber = requiredWinningNumber;
        this.hasBonusNumber = hasBonusNumber;
        this.reward = reward;
    }
}
