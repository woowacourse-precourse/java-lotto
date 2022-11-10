package exception;

public enum MoneyExceptionType{
    NOT_THOUSAND_MONEY("[Error] 구입 금액이 1000원 단위가 아닙니다."),
    NO_NUMBER_MONEY("[ERROR] 구입 금액은 숫자여야 합니다."),
    NOT_MONEY_NEGATIVE("[ERROR] 구입 금액은 항상 양수여야 합니다.");

    private String errorMessage;

    MoneyExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
