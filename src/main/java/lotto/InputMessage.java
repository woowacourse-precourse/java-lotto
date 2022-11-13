package lotto;

public enum InputMessage {
    USER_PAY("구입금액을 입력해 주세요."),
    USER_NUMS("당첨 번호를 입력해 주세요."),
    USER_BONUS_NUM("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }
}
