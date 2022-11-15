package lotto.type;

public enum MessageType {
    BUY("구입금액을 입력해 주세요."),
    WIN("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    COUNT_MESSAGE("%d개를 구매했습니다."),
    RESULT_HEAD("당첨통계\n---"),
    RESULT_COUNT("%d개 일치%s (%s원) - %s개"),
    RESULT_YIELD("총 수익률은 %s%%입니다."),
    BONUS_MATCH(", 보너스 볼 일치"),
    ;

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
