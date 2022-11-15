package lotto.message;

public enum PrintMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    PURCHASE_QUANTITY("개를 구매했습니다."),

    YIELD_RATE_PREVIOUS("총 수익률은 "),
    YIELD_RATE_NEXT("입니다.");

    final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
