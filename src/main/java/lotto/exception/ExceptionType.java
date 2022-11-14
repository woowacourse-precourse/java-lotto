package lotto.exception;

import static lotto.util.ConstValue.LottoConst.ERROR_PREFIX;

public enum ExceptionType {

    // LOTTO INPUT ERROR
    NOT_NUMBER(ERROR_PREFIX, "자연수를 입력해주세요."),
    NULL_INPUT(ERROR_PREFIX, "null 입력은 허용되지 않습니다."),
    WINNING_LOTTO_NUMBER_INPUT_PATTERN_NOT_MATCH(ERROR_PREFIX, "당첨 번호 입력 패턴이 일치하지 않습니다. Ex) 1,2,3,4,5,6"),

    // LOTTO NUMBER ERROR
    LOTTO_NUMBER_OUT_OF_RANGE(ERROR_PREFIX, "로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE(ERROR_PREFIX, "로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_LENGTH_ERROR(ERROR_PREFIX, "로또 번호는 6개여야 합니다"),
    ;

    private final String type;
    private final String message;

    ExceptionType(final String type, final String message) {
        this.type = type;
        this.message = message;
    }

    public String getMessage() {
        return type + " " + message;
    }
}
