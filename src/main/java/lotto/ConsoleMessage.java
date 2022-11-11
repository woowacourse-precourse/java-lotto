package lotto;

public enum ConsoleMessage {
    REQUEST_PURCHASE("구입금액을 입력해주세요."),
    RESPONSE_PURCHASE("%d개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨통계\n---"),
    STATISTICS_ELEMENT_FORMAT("%s - %d 개"),
    RESPONSE_YIELD("총 수익률은 %lf% 입니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
