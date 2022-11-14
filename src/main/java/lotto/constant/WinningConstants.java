package lotto.constant;

public enum WinningConstants {

    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    private final int requiredWinningNumber;
    private final boolean hasBonusNumber;
    private final int reward;

    WinningConstants(int requiredWinningNumber, boolean hasBonusNumber, int reward) {
        this.requiredWinningNumber = requiredWinningNumber;
        this.hasBonusNumber = hasBonusNumber;
        this.reward = reward;
    }
}
