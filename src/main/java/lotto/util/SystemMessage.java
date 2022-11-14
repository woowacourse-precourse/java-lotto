package lotto.util;

public enum SystemMessage {
    PURCHASE_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계");

    private String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
