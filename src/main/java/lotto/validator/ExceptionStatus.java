package lotto.validator;

public enum ExceptionStatus {
    NO_DIGIT("구매 금액은 숫자만 입력할 수 있습니다."),
    NO_THOUSAND_UNIT("구매 금액은 1000단위로 입력할 수 있습니다."),
    NO_DUPLICATE_NUMBER("중복 되는 당첨 번호를 입력할 수 없습니다"),
    NO_OVER_SIX_NUMBERS("6개의 당첨 번호만 입력할 수 있습니다."),
    NUMBER_RANGE_EXCEPTION("1 ~ 45 사이의 숫자만 입력할 수 있습니다."),
    NO_CONTAIN_WINNING_LOTTO_NUMBERS("보너스 숫자는 당첨 번호를 포함할 수 없습니다"),
    REGEX_EXCEPTION("올바른 당첨번호 입력 방식이 아닙니다");


    private final String message;
    private static final String PREFIX = "[ERROR] ";

    ExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
