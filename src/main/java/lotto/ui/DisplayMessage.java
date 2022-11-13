package lotto.ui;

public enum DisplayMessage {

    REQUEST_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    ANNOUNCE_PURCHASED_COUNT("개를 구매했습니다."),
    REQUEST_LOTTO_WINNER_NUMBER("당첨 번호를 입력해 주세요"),
    REQUEST_LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ANNOUNCE_LOTTO_STAT("당첨 통계\n---"),

    THREE_NUMBER_MATCH_PREFIX("3개 일치 (5,000원) - "),
    FOUR_NUMBER_MATCH_PREFIX("4개 일치 (50,000원) - "),
    FIVE_NUMBER_MATCH_PREFIX("5개 일치 (1,500,000원) - "),
    FIVE_AND_BONUS_NUMBER_MATCH_PREFIX("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_NUMBER_MATCH_PREFIX("6개 일치 (2,000,000,000원) - "),
    LOTTO_EARNINGS_LATE_PREFIX("총 수익률은 ");

    String message;

    DisplayMessage(String message) {
        this.message = message;
    }
}
