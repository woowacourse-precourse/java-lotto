package lotto.resources;

public enum LottoResultMessage {
    THREE_MATCHES("3개 일치 (5,000원) - ", 5),
    FOUR_MATCHES("4개 일치 (50,000원) - ", 4),
    FIVE_MATCHES("5개 일치 (1,500,000원) - ", 3),
    FIVE_MATCHES_AND_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 2),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - ", 1);

    private String message;
    private int rank;

    LottoResultMessage(String message, int rank) {
        this.message = message;
        this.rank = rank;
    }

    public String getMessage() {
        return message;
    }

    public int getRank() {
        return rank;
    }
}
