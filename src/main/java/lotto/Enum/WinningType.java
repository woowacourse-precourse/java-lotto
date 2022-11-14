package lotto.Enum;

public enum WinningType {
    RANK5_WINNING_MESSAGE("3개 일치"),
    RANK4_WINNING_MESSAGE("4개 일치"),
    RANK3_WINNING_MESSAGE("5개 일치"),
    RANK2_WINNING_MESSAGE("5개 일치, 보너스 볼 일치"),
    RANK1_WINNING_MESSAGE("6개 일치");

    private final String winningMessage;
    WinningType(String message) {
        this.winningMessage = message;
    }

    public String getWinningMessage() {
        return winningMessage;
    }
}
