package lotto.view.print.enums;

public enum WinningHistoryMessage {
    PRINT_FIFTH("3개 일치 (5,000원) - ", "FIFTH"),
    PRINT_FOURTH("4개 일치 (50,000원) - ", "FOURTH"),
    PRINT_THIRD("5개 일치 (1,500,000원) - ", "THIRD"),
    PRINT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", "SECOND"),
    PRINT_FIRST("6개 일치 (2,000,000,000원) - ", "FIRST");

    private final String message;
    private final String ranking;

    WinningHistoryMessage(String message, String ranking) {
        this.message = message;
        this.ranking = ranking;
    }

    public String getMessage() {
        return message;
    }

    public String getRanking() {
        return ranking;
    }
}