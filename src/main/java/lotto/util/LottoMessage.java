package lotto.util;

public enum LottoMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    QUANTITY("%d개를 구매했습니다.\n"),
    INPUT_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_RESULT("당첨 통계\n"
            + "---\n"
            + "3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (50,000원) - %d개\n"
            + "5개 일치 (1,500,000원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
            + "6개 일치 (2,000,000,000원) - %d개\n"),
    PROFIT("총 수익률은 %s입니다.\n");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
