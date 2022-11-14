package lotto.resource.message;

public enum FixedMessage {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_COUNT("개를 구매했습니다.");

    private final String message;

    FixedMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
