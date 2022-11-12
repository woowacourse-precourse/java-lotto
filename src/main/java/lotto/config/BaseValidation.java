package lotto.config;

public enum BaseValidation {

    INVALID_PAY_MONEY("[ERROR] : 금액은 1,000원 단위로 입력하시오."),
    OVER_CAPACITY_LOTTO("[ERROR] : 6개의 당첨 번호를 가진 로또가 아닙니다."),
    DUPLICATION_NUMBER_LOTTO("[ERROR] : 중복된 당첨 번호를 가진 로또입니다.");

    private final String message;

    private BaseValidation(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
