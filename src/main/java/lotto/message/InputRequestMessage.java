package lotto.message;

import device.message.Message;

public enum InputRequestMessage implements Message {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private String message;

    InputRequestMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
