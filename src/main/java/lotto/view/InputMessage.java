package lotto.view;

public enum InputMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_QUANTITY("개를 구매했습니다.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}

