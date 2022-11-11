package domain;

public enum InputMessage {
    INPUT_BUY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");


    final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
