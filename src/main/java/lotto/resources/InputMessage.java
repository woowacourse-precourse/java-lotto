package lotto.resources;

public enum InputMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
