package lotto;

public enum ErrorCode {
    INPUT_NOT_NUMBER("입력값이 숫자가 아닙니다."),
    NOT_UNIQUE_NUMBERS("중복된 숫자가 존재합니다."),
    INVALID_SIZE("로또는 번호는 6자리여야 합니다.")
    ;

    private String message;
    ErrorCode(String message) {
        this.message = message;
    }
}
