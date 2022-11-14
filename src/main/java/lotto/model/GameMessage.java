package lotto.model;

public enum GameMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    OUTPUT_PURCHASE_QUANTITY("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATICS("당첨 통계"),
    DASH("---"),
    THREE_CORRECT("3개 일치 (5,000원) - "),
    FOUR_CORRECT("4개 일치 (50,000원) - "),
    FIVE_CORRECT("5개 일치 (1,500,000원) - "),
    FIVE_AND_BONUS_CORRECT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_CORRECT("6개 일치 (2,000,000,000원) - "),
    COUNT("개"),
    TOTAL_START("총 수익률은 "),
    TOTAL_END("%입니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
