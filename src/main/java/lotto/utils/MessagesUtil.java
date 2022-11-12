package lotto.utils;

public enum MessagesUtil {
    INPUT_BUY_MONEY("구입금액을 입력해 주세요.");

    private final String message;

    MessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
