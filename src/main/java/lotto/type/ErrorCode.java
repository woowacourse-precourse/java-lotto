package lotto.type;

public enum ErrorCode {

    NON_NUMERIC_VALUE("숫자가 아닌 값은 입력할 수 없습니다."),
    TOO_BIG_OR_TOO_SMALL_VALUE("너무 크거나 작은 값입니다."),
    COULD_NOT_DIVIDE_BY_SMALLEST_UNIT("최소 단위로 나눌 수 없는 값입니다."),
    LOTTO_SIZE_ERROR("로또 번호는 6자리 입니다."),
    MINIMUM_SIZE_CREATE_ERROR("로또는 최소 1개 이상만 발행할 수 있습니다."),
    DUPLICATE_ERROR("중복되는 값이 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
