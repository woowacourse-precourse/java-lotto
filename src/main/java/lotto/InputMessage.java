package lotto;

public enum InputMessage {

    WIN_NUMBER_MESSAGE("당첨 번호를 입력해주세요"),
    PURCHASE_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요");

    String message;

    InputMessage(String message) {
        this.message = message;
    }
}
