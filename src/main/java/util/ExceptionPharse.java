package util;

public enum ExceptionPharse {
    ERROR("[ERROR] "),
    IS_NULL("아무것도 입력하지 않았습니다."),
    IS_NOT_NUMBER("숫자가 아닌 값입니다."),
    IS_NOT_DIVIDED("최소 단위로 나눠지지 않습니다."),
    IS_OUT_OF_RANGE("범위 밖의 숫자를 입력하셨습니다."),
    OUT_OF_LOTTO_SIZE("로또 갯수는 6개여야 합니다."),
    IS_NOT_FORMAT("입력 규격이 아닙니다."),
    WRONG_DATA("잘못된 값이 존재 합니다."),
    DUPLICATE("중복된 값이 존재 합니다.");

    private final String exceptionMsg;

    ExceptionPharse(String msg) {
        this.exceptionMsg = msg;
    }

    public String getExceptionMsg() {
        return ERROR.exceptionMsg + exceptionMsg;
    }
}
