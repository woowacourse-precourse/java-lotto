package lotto.enums;

public enum InputMessage {
    MONEY_INPUT_MESSAGE("구입금액을 입력해 주세요."), WINNING_NUMBERS_INPUT_MESSAGE("당첨 번호를 입력해 주세요."), BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
