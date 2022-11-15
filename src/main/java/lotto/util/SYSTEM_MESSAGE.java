package lotto.util;

public enum SYSTEM_MESSAGE {
    PURCHASE_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---"),
    TOTAL_RETURN("총 수익률은 %.1f %%입니다.");

    private String message;

    SYSTEM_MESSAGE(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
