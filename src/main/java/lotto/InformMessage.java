package lotto;

public enum InformMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n"),
    EARNING_RATE("총 수익률은 .1f%입니다.\n");

    private final String MESSAGE;

    InformMessage(final String message) {
        this.MESSAGE = message;
    }
    @Override
    public String toString() {
        return (MESSAGE);
    }
}
