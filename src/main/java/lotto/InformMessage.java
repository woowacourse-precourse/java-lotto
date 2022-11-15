package lotto;

public enum InformMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---\n"),
    THREE_CORRECT("3개 일치 (5,000원) - "),
    FOUR_CORRECT("4개 일치 (50,000원) - "),
    FIVE_CORRECT("5개 일치 (1,500,000원) - "),
    BONUS_CORRECT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    ALL_CORRECT("6개 일치 (2,000,000,000원) - "),
    EARNING_RATE("총 수익률은 .1f%입니다.");

    private final String MESSAGE;

    InformMessage(final String message) {
        this.MESSAGE = message;
    }
    @Override
    public String toString() {
        return (MESSAGE);
    }
}
