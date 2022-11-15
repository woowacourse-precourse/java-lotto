package lotto.constant;

public enum UserInputMessage {

    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    UserInputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
