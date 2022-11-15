package lotto.Exception;

public enum ErrorType {
    ZERO_AMOUNT("금액이 부족하여 로또를 구매할 수 없습니다."),
    INDIVISIBLE_THOUSAND("구입 금액은 1,000원 단위여야 합니다."),
    NOT_NUMBER("금액은 숫자여야 합니다."),
    NOT_SIX_NUMBERS("당첨 번호는 6개여야 합니다."),
    NOT_ONE_TO_FOURTYFIVE("당첨 번호는 1~45 사이어야 합니다."),
    DUPLICATED_NUMBER("당첨 번호는 각각 중복되지 않아야 합니다.");

    final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = "[ERROR] " + errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

}
