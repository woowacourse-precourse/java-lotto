package lotto.exception;

public enum ExceptionPhrase {

    EXCEPTION_DUPLICATE_NUMBER("로또 번호에 중복된 숫자가 있으면 예외가 발생한다."),
    EXCEPTION_INVALID_MONEY_UNIT("1000원 단위로 입력해주세요"),
    EXCEPTION_INVALID_INPUT("숫자만 입력 가능합니다.");

    private String message;

    ExceptionPhrase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
