package lotto.util;

public enum InformationMessage {
    INPUT_PRICE("구매금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_PURCHASE_COUNT("개를 구매했습니다."),
    PRINT_WINNING_RESULT("당첨 통계"),
    PRINT_RATE_OF_RETURN("총 수익률은 %,.1f%%입니다."),
    DIVISOR("---");

    private final String message;

    InformationMessage(String message) {
        this.message = message;
    }

    public void print(Object... args) {
        System.out.printf((message) + "%n", args);
    }

    public String getMessage() {
        return message;
    }
}
