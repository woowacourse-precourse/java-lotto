package lotto.enums;

public enum ErrorMessage {
    NUM_ERROR("[ERROR] 숫자만 입력해주세요."),
    LEN_ERROR("[ERROR] 6자리 숫자를 입력해주세요."),
    RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_ERROR("[ERROR] 중복 없이 입력해주세요."),
    PRICE_ERROR("[ERROR] 금액은 1000원 단위로 입력해주세요.");


    private final String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
