package lotto.Exception;

public enum ErrorType {
    ZERO_AMOUNT("금액이 부족하여 로또를 구매할 수 없습니다."),
    INDIVISIBLE_THOUSAND("구입 금액은 1,000원 단위여야 합니다."),
    NOT_NUMBER("구입 금액은 숫자여야 합니다.");

    final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = "[ERROR] " + errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

}
