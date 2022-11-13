package lotto.message.input;

public enum InputMessage {

    WIN_NUMBER_MESSAGE("당첨 번호를 입력해주세요"),
    PURCHASE_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요");

    public String message;

    InputMessage(String message) {
        this.message = message;
    }
}
