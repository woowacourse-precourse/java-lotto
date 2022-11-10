package lotto.util;

public enum IOMessage {
    READ_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    READ_WINNING_NUM_MESSAGE("당첨 번호를 입력해 주세요."),
    READ_BONUS_NUM_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
