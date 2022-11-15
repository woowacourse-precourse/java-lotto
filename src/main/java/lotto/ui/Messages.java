package lotto.ui;

public enum Messages {
    ERROR_PREFIX("[ERROR] "),
    ERROR_MONETARY_UNIT("구입 금액은 천원 단위여야 합니다."),
    ERROR_WINNING_NUMBER_FORMAT("당첨번호는 쉼표와 숫자만 입력가능합니다."),
    ERROR_WINNING_NUMBER_SIZE("6자리 숫자만 입력가능합니다."),
    ERROR_NUMBER_RANGE("1부터 45까지의 범위 내에서 입력가능합니다."),
    ERROR_NUMBER_FORMAT("숫자만 입력가능합니다."),
    ERROR_NUMBER_OVERLAP("당첨번호와 중복되지 않는 수를 입력해 주세요.");

    private String message;

    private Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
