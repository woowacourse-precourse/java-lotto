package exception;

public enum MoneyExceptionType{
    NOT_THOUSAND_MONEY(600, "[Error] 구입 금액이 1000원 단위가 아닙니다."),
    NO_NUMBER_MONEY(601, "[ERROR] 구입 금액은 숫자여야 합니다."),
    NOT_MONEY_NEGATIVE(602, "[ERROR] 구입 금액은 항상 양수여야 합니다.");

    private int errorCode;
    private String errorMessage;

    MoneyExceptionType(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
