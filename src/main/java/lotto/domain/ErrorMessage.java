package lotto.domain;

public enum ErrorMessage {
    PURCHASE_MONEY_TYPE("[ERROR] 구입 금액은 숫자여야합니다."),
    PURCHASE_MONEY_UNIT("[ERROR] 구입 금액은 천원 단위 입니다."),
    LOTTO_NUMBER_COUNT("[ERROR] 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 번호는 중복되지 않아야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
