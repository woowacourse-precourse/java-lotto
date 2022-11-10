package constant;

public enum Text {
    REQUEST_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다."),
    REQUEST_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---\n"),
    MATCHES("%d개 일치 (%s원) - %d개"),
    YIELD("총 수익률은 %d%%입니다."),
    ;

    final String content;

    Text(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }
}
