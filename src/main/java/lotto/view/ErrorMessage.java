package lotto.view;

public enum ErrorMessage {
    ONLY_NUMBER_POSSIBLE("숫자만 입력할 수 있습니다."),
    ONLY_THOUSAND_UNIT_POSSIBLE("1,000원 단위로 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
