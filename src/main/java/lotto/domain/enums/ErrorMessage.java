package lotto.domain.enums;

public enum ErrorMessage {
    DATA_TYPE_ERR_MESSAGE("[ERROR] 숫자만 입력 가능합니다."),
    NUMBER_SIZE_ERR_MESSAGE("[ERROR] 로또 숫자는 6개 입니다"),
    NUMBER_DUPLICATE_ERR("[ERROR] 중복된 번호는 사용할 수 없습니다."),
    PRICE_ERROR_MESSAGE("[ERROR] 구입 금액은 천원 단위로 입력하셔야만 합니다."),
    INVALID_SEP_MESSAGE("[ERROR] 숫자와 구분자(,)만 입력 가능합니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
