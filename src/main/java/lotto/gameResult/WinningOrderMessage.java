package lotto.gameResult;

public enum WinningOrderMessage {
    FIFTH("3개 일치 (5,000원) - "),
    FOUFTH("4개 일치 (50,000원) - "),
    THIRD("5개 일치 (1,500,000원) - "),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST("6개 일치 (2,000,000,000원) - ")
    ;

    private final String message;

    WinningOrderMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}