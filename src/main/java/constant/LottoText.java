package constant;

public enum LottoText {
    REQUEST_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다.\n"),
    REQUEST_WIN_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---\n"),
    MATCHES("%d개 일치 (%s원) - %d개"),
    YIELD("총 수익률은 %d%%입니다."),
    ERROR("[ERROR] ")
    ;

    final String content;

    LottoText(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
