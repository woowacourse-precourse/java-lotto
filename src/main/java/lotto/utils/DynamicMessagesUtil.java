package lotto.utils;

public enum DynamicMessagesUtil {
    BUY_COUNT("%s개를 구매했습니다."),
    LOTTO_NUMBERS("[%s]");

    private final String message;

    DynamicMessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
