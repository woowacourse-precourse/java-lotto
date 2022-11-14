package lotto.resource;

public enum MessageType {
    PURCHASE_PRICE("구매금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_COMPLETION("%d개를 구매했습니다."),
    WINNING_RESULT("당첨 통계\n---\n총 수익률은 %.1f%%입니다.");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
