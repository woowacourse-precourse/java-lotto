package lotto;

public enum Message {
    INPUT_PURCHASE_PRICE("구입 금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    MATCH_THREE_NUMBERS("3개 일치 (5,000원) - "),
    MATCH_FOUR_NUMBERS("4개 일치 (50,000원) - "),
    MATCH_FIVE_NUMBERS_WITHOUT_BONUS("5개 일치 (1,500,000원) - "),
    MATCH_FIVE_NUMBERS_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_SIX_NUMBERS("6개 일치 (2,000,000,000원) - "),

    STATISTICS("당첨 통계"),
    TOTAL_RETURN_ON_INVESTMENT("총 수익률은 ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
