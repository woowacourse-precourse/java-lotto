package lotto.enums;

public enum InputMessage {
    MONEY_INPUT_MESSAGE("구입금액을 입력해 주세요."), WINNING_NUMBERS_INPUT_MESSAGE("당첨 번호를 입력해 주세요."), BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    ERROR_MESSAGE("[ERROR] 잘못된 값을 입력했습니다. 프로그램을 종료합니다.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
