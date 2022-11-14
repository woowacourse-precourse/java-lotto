package lotto.enums;

public enum ErrorMessage {
    NUM_ERROR("[ERROR] 숫자만 입력해주세요."),
    LEN_ERROR("[ERROR] 6자리 숫자를 입력해주세요."),
    RANGE_ERROR("[ERROR] 1부터 45 사이의 숫자를 입력해주세요."),
    DUPLICATE_ERROR("[ERROR] 중복 없이 입력해주세요.")
    ;

    private final String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
