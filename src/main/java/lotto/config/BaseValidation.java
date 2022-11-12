package lotto.config;

public enum BaseValidation {

    INVALID_PAY_MONEY("[ERROR] : 금액은 1,000원 단위로 입력하시오."),
    INVALID_LOTTO("[ERROR] : 잘못된 로또입니다.");

    private final String message;

    private BaseValidation(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
