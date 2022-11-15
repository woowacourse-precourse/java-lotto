package lotto.util;

public enum OutputMessage {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT("당첨 통계%n" + "---");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String printMessage() {
        return message;
    }
}
