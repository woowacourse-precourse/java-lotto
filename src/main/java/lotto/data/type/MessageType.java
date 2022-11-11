package lotto.data.type;

public enum MessageType {
    BUY("구입금액을 입력해 주세요."),
    WIN("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
