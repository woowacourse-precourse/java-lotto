package lotto.utils.message;

public enum DynamicMessagesUtil {
    BUY_AMOUNT("\n%s개를 구매했습니다."),
    LOTTO_NUMBERS("[%s]"),
    PROFIT("총 수익률은 %.1f%%입니다.");

    private final String message;

    DynamicMessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
