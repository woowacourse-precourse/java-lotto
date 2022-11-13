package lotto.message;

public enum WinningMessage {
    FIFTH_OPTION("3개 일치 (5,000원) - "),
    FOURTH_OPTION("4개 일치 (50,000원) - "),
    THIRD_OPTION("5개 일치 (1,500,000원) - "),
    SECOND_OPTION("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_OPTION("6개 일치 (2,000,000,000원) - ");

    private final String message;

    WinningMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
